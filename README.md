## Pass in Cucumber tags at runtime when execute tests using a custom runner class
By default, Katalon doesn't allow users to pass in tags at runtime (e.g. using GlobalVariable) WHEN a custom runner class is used. However, it could be overcome by overriding the CucumberOptions annotation of the runner class. Below is a **Test Case** illustrating how one can use the provided overrider.

```groovy
new CucumberOptionsOverrider(MyRunner.class).tags(GlobalVariable.TAGS).override()
/*
 * or
 * new CucumberOptionsOverrider(MyRunner.class).tags(["@yourtags"]).override()
 */

CucumberKW.runWithCucumberRunner(MyRunner.class)
```

