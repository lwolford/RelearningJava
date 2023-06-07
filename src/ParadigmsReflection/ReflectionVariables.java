package ParadigmsReflection;

public class ReflectionVariables {

    private String strVariable;

    public ReflectionVariables() {
        strVariable = "Hello";
    }

    public void stringMethod() {
        System.out.println("The String is: " + strVariable);
    }

    public void characterMethod(char charVariable) {
        System.out.println("The character is: " + charVariable);
    }

    private void privateMethod() {
        System.out.println("This is private. You shouldn't be able to see this.");
    }

}
