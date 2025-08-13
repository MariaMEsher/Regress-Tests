package tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({


//CreateDealNegativeTests .class,
        TestCreate.class,

CreateDealTests.class,
CopyDealsTests.class,
CheckWorkingWithDealsTests.class,
CheckApprovalsTests.class,
CreateCancelShipmentTests.class,
//CheckСreatingTransportationсCostsTests.class,
//CheckCreatingTransportationTests.class,
//CheckMaterialMovementTests.class,
//CheckingСreationNewPositionsTests.class,
//CheckingPositionChangesTests.class,
//CheckMultipleOperationsTests.class,
//FunctionalCostsShipmentTests.class,
//VesselContainerTests.class

})
public class TestSuiteRunner {




}