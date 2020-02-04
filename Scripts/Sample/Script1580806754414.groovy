import com.bdd.annotation.CucumberOptionsOverrider
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.test.runner.MyRunner

/*
 * This line should be put in a hook 
 * This also allows you to flexibly pass in tags at runtime by using GlobalVariable
 */
new CucumberOptionsOverrider(MyRunner.class).tags(["@smoke"]).override()

CucumberKW.runWithCucumberRunner(MyRunner.class)

