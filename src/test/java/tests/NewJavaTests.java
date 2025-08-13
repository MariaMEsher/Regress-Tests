package tests;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import pages.DealPage;
import pages.ShipmentPage;

import static com.codeborne.selenide.Selenide.*;

public class NewJavaTests {


    public void CopyNew(){
        }


        @Test

        public void CopyNewDeal() {
            DealPage dealPage = page(DealPage.class);
            ShipmentPage shipmentPage = page(ShipmentPage.class);
            SalesOrderOperation salesOrderOperation = new SalesOrderOperation();
            MaterialMovementOperation materialMovementOperation = new MaterialMovementOperation();
            SaleOrderConfirm saleOrderConfirm = new SaleOrderConfirm();


open("https://ya.ru/showcaptcha?cc=1&mt=1189A55B56DC0980E805C8480E3249418BFFB0A6CBFAE6EF4FD55C5C10EF64C880733899EDF2E5931794DFCFC852B168E22DDA9BF61622EEFDE819D0D4BC9D9C6854096DBBD4E343166B6975834FC0BBB1FD6CF11311353CF1DC5EE66499D7C8180B6167C650424719322C7FFF7C6934A6B8F3CD26736776A91BDA243E22B85BB28BD8309FB0B01FCC13EFD8AE97679C3B4A289805C0CF61FFED9F18FDDD66CF9B13038A896D6E9CE158C4C418D6E39656AF70B4EECB799FF9DE30E6757BB72A5FE001D482A3005AEA8AFD0FFAB0246324388F7DCBA49B59C2663A23C0&retpath=aHR0cHM6Ly95YS5ydS8_bnI9MSZyZWRpcmVjdF90cz0xNzM5ODAzNjg0LjAwMDAw_0f8fccb64f85e36b77bac730e2f44bdb&t=2/1739803684/44fad806b9052350a20e90c16adecf1c&u=6075784385204981351&s=803cb455b692b77fb0c9943f64440a34");
$x("//input[@class='CheckboxCaptcha-Button']").click();


            Selenide.sleep(5555);









        }

    }


