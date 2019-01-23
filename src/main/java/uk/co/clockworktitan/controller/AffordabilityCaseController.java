package uk.co.clockworktitan.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.clockworktitan.*;
import uk.co.clockworktitan.model.*;

import java.text.NumberFormat;
import java.util.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/AffordabilityCase") // This means URL's start with /AffordabilityCase (after Application path)


public class AffordabilityCaseController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AffordabilityCaseRepository AffordabilityCaseRepository;
    // used to populate case from quote
    @Autowired
    private QuoteSummaryRepository _QuoteSummaryRepository;
    @Autowired
    private ProjectionRepository _ProjectionRepository;
    @Autowired
    private IncomeRepository _IncomeRepository;
    @Autowired
    private OutgoingsRepository _OutgoingsRepository;
    @Autowired
    private InflationRepository  _InflationRepository;
    private Inflation       _Inflation;
    private Inflation[] _InflationList;

    //@GetMapping(path="/add") // Map ONLY GET Requests
    @PostMapping(path="/add")
    public @ResponseBody  String addNewUser (@RequestBody AffordabilityCase _AffordabilityCase) {

        AffordabilityCase n = new AffordabilityCase();
        if (_AffordabilityCase.getId()!= null)
        {
            //Record ID is being passed, so must be updating an existing record
            System.out.println("System ID: " + _AffordabilityCase.getId());
            n.setId(_AffordabilityCase.getId());
        }
        else
            // no ID passed, so must be a new record
        {System.out.println("Blank System ID "); }
        n.setoriginatingQuoteID(_AffordabilityCase.getoriginatingQuoteID());
        n.setName(_AffordabilityCase.getName());
        n.setApplicantCount(_AffordabilityCase.getApplicantCount());
        n.setApplicant1Name(_AffordabilityCase.getApplicant1Name());
        n.setApplicant2Name(_AffordabilityCase.getApplicant2Name());
        AffordabilityCaseRepository.save(n);

        JSONObject obj = new JSONObject();

        obj.put("id", n.getId());

        return obj.toJSONString();
    }

    @PostMapping(path="/CreatefromQuote/")
    public @ResponseBody  String CreateFromQuote (@RequestBody QuoteSummary _QuoteSummary) {
    Integer CaseRecordID = 0;
    AffordabilityCase CaseRecord = AffordabilityCaseRepository.findOneByoriginatingQuoteID(_QuoteSummary.getId());
    if ( CaseRecord== null)
        {
            // No case record exists for the quote, so will create a new one
            Calendar cal = Calendar.getInstance();
            AffordabilityCase n = new AffordabilityCase();
            QuoteSummary tinker = _QuoteSummaryRepository.findOne(_QuoteSummary.getId());
            System.out.println("creating an affordability case for quote " + _QuoteSummary.getId());
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
            String Amount = format.format(tinker.getAmount());

            n.setName("Case for " + tinker.getApplicant1Name()+ " & "+ tinker.getApplicant2Name()  + " for product " + tinker.getProductDescription() + " for the value of " + Amount );
            n.setApplicantCount(tinker.getApplicantCount());
            n.setApplicant1Name(tinker.getApplicant1Name());
            n.setApplicant2Name(tinker.getApplicant2Name());
            // while the case/quote maybe for specific dates, we only check affordability at a year level

            cal.setTime(tinker.getFromDate());
            n.setFromYear( cal.get(Calendar.YEAR));
            cal.setTime(tinker.getToDate());
            n.setToYear(cal.get(Calendar.YEAR));
            n.setoriginatingQuoteID(_QuoteSummary.getId());
            AffordabilityCaseRepository.save(n);
            tinker.setProceededWith(true); // set the Quote Summary Record to show a DIP case has been created
            _QuoteSummaryRepository.save(tinker);
            CaseRecordID = n.getId();
        }
        else
        {
            CaseRecordID= CaseRecord.getId();
        }

        JSONObject obj = new JSONObject();

        obj.put("id", CaseRecordID);

        return obj.toJSONString();
    }

    @PostMapping(path="/CreateProjection/")
    public @ResponseBody  String CreateProjection (@RequestBody AffordabilityCase _AffordabilityCase) {
        System.out.println("CreateProjection called");
        AffordabilityCase CaseRecord = AffordabilityCaseRepository.findOne(_AffordabilityCase.getId());
        if ( CaseRecord != null) {

            System.out.println("Creating a projection for years"+ CaseRecord.getFromYear() + " to " +CaseRecord.getToYear());
            Integer iteratorYear = CaseRecord.getFromYear();

            while (iteratorYear <= CaseRecord.getToYear()) {
                getInflationBetweenYears(CaseRecord.getFromYear()+1, iteratorYear);
                Projection CaseProjection = new Projection();
                Double DefaultIncomeForYear = getDefaultIncomeForYear(_AffordabilityCase.getId(), iteratorYear);
                Double OutgoingsAmountForYear = getOutgoingsForYear(_AffordabilityCase.getId(), iteratorYear);
                Double DefaultSurplusForYear = DefaultIncomeForYear - OutgoingsAmountForYear;
                System.out.println("Creating projection for year:" + iteratorYear);
                CaseProjection.setProjectionYear(iteratorYear);
                CaseProjection.setAffordabilityCaseID(_AffordabilityCase.getId());
                //System.out.println(getDefaultIncomeForYear(_AffordabilityCase.getId(), iteratorYear));

                CaseProjection.setDefaultIncomeAmount(DefaultIncomeForYear);
                CaseProjection.setOutgoingsAmount(OutgoingsAmountForYear);
                CaseProjection.setDefaultSurplusAmount(DefaultSurplusForYear);
                _ProjectionRepository.save(CaseProjection);
                iteratorYear++;
            }
        }
        else
        {
            System.out.println("No Case Record Found!");
        }

        JSONObject obj = new JSONObject();

        obj.put("id", 1);

        return obj.toJSONString();
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<AffordabilityCase> getAllUsers() {
        // This returns a JSON or XML with the users
        return AffordabilityCaseRepository.findAll();
    }

    @GetMapping(path="/FindbyID/{AffordabilityCaseID}")
    public @ResponseBody AffordabilityCase getSingleAffordabilityCase(@PathVariable(value="AffordabilityCaseID") int num1 ) {
        // This returns a JSON or XML with a single user
        System.out.println("Query Paramter:" + num1);
        return AffordabilityCaseRepository.findOne(num1);
    }

    @GetMapping(path="/DeletebyID/{UserID}")
    public @ResponseBody void DeleteSingleUser(@PathVariable(value="UserID") int num2 ) {
        // This returns a JSON or XML with a single user
       // System.out.println("Query Paramter:" + num1);
        AffordabilityCaseRepository.delete(num2);
    }

    private Double getDefaultIncomeForYear(Integer AffordabilityCaseID, Integer ProjectionYear)
    {
            Iterable <Income> _Income  = _IncomeRepository.findAllByAffordabilityCaseIDandYear(AffordabilityCaseID, ProjectionYear);
            Iterator<Income>  _IncomeIterator = _Income.iterator();
            Double ReturnAmount = 0.0;
            while (_IncomeIterator.hasNext())
            {
                Income IncomeRecord = _IncomeIterator.next();
                System.out.println("Iterating Income Set");
                if (IncomeRecord.getIndexLinked()==true)
                {
                    ReturnAmount = ReturnAmount + (IncomeRecord.getAmount()* getInflationBetweenYears(IncomeRecord.getFromYear()+1, ProjectionYear));
                }
                else
                {ReturnAmount = ReturnAmount + IncomeRecord.getAmount(); }

                //TODO add weighting into calculation

            }
       this.populateInflationData();;

        return ReturnAmount;
    }
    private Double getOutgoingsForYear(Integer AffordabilityCaseID, Integer ProjectionYear)
    {
        Iterable <Outgoings> _Outgoings  = _OutgoingsRepository.findAllByAffordabilityCaseIDandYear(AffordabilityCaseID, ProjectionYear);
        Iterator<Outgoings>  _OutgoimgsIterator = _Outgoings.iterator();
        Double ReturnAmount = 0.0;
        while (_OutgoimgsIterator.hasNext())
        {
            Outgoings OutgoingsRecord = _OutgoimgsIterator.next();
            System.out.println("Iterating Outgoings Set");
            ReturnAmount = ReturnAmount + (OutgoingsRecord.getAmount()* getInflationBetweenYears(OutgoingsRecord.getFromYear()+1, ProjectionYear) );

        }


        return ReturnAmount;
    }
    private Double getInflationBetweenYears(Integer  StartYear, Integer EndYear)
    {
        Integer YearIterator = StartYear;
        Double YearAmount = 0.0;
        Double TotalAmount = 1.0;
        while (YearIterator <= EndYear )
        {
            ////////////////////////////////////////////////////////
            Iterable <Inflation> _Inflation  = _InflationRepository.findAllByInflationYear( YearIterator);
            Iterator<Inflation>  _InflationIterator = _Inflation.iterator();
            YearAmount = 0.0;
            while (_InflationIterator.hasNext())
            {
                Inflation InflationRecord = _InflationIterator.next();
                YearAmount = YearAmount + InflationRecord.getinflation();
                //TODO - this will return the wrong value in the event of duplicate records (need to set constraints on table)

            }
            //System.out.println("Year: "+ YearIterator + " YearAmount: " + YearAmount);

            TotalAmount = TotalAmount+ ((YearAmount/100) * TotalAmount);
            ///////////////////////////////////////////////////////
            YearIterator++;
        }

        System.out.println("Total Inflation Between Years"+ StartYear + " - " + EndYear + "=" + TotalAmount);

        return TotalAmount;
    }

    private Double SF_getInflationBetweenYears(Integer  StartYear, Integer EndYear)
    {
        Integer YearIterator = StartYear;
        Double YearAmount = 0.0;
        Double TotalAmount = 1.0;
        while (YearIterator <= EndYear )
        {
            ////////////////////////////////////////////////////////
            //////Iterable <Inflation> _Inflation  = _InflationRepository.findAllByInflationYear( YearIterator);
            ///Iterator<Inflation>  _InflationIterator = _Inflation.iterator();
            _InflationList.
            YearAmount = 0.0;
            while (_InflationIterator.hasNext())
            {
                Inflation InflationRecord = _InflationIterator.next();
                YearAmount = YearAmount + InflationRecord.getinflation();
                //TODO - this will return the wrong value in the event of duplicate records (need to set constraints on table)

            }
            //System.out.println("Year: "+ YearIterator + " YearAmount: " + YearAmount);

            TotalAmount = TotalAmount+ ((YearAmount/100) * TotalAmount);
            ///////////////////////////////////////////////////////
            YearIterator++;
        }

        System.out.println("Total Inflation Between Years"+ StartYear + " - " + EndYear + "=" + TotalAmount);

        return TotalAmount;
    }

    private void populateInflationData()
    {
        List <Inflation> tinker;
        Iterable <Inflation> _Inflation  = _InflationRepository.findAll();
        Iterator<Inflation> _InflationIterator = _Inflation.iterator();
        Integer Counter =0;
        _InflationList = new Inflation[Math.toIntExact(_InflationRepository.count()) ];
        tinker = new < List> Inflation();
        while (_InflationIterator.hasNext())
        {
         Inflation InflationRecord = _InflationIterator.next();
         _InflationList[Counter] = new Inflation(InflationRecord.getinflationYear() , InflationRecord.getinflation());
         tinker.add(Counter,  InflationRecord);
          // this._InflationList[Counter].setinflation(InflationRecord.getinflation  ());
        System.out.println("Populate called");
        Counter++;

        }
        Counter = 0;
        while (Counter < _InflationList.length)
        {
            System.out.println(_InflationList[Counter].toString());
            Counter++;
        }

    }
}
