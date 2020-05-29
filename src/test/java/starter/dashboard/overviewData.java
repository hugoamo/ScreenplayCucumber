package starter.dashboard;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;


public class overviewData {
    public static Question<String>CreditAviable(){
        return  actor -> TextContent.of(FinalcialOverview.CREDIT_AVAILABLE).viewedBy(actor).asString().trim();
    }

}
