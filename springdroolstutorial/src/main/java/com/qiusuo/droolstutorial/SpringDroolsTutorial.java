package com.qiusuo.droolstutorial;

import com.qiusuo.droolstutorial.model.Product;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class SpringDroolsTutorial {
    public static void main(String[] args) throws DroolsParserException, IOException {
        SpringDroolsTutorial droolsTest = new SpringDroolsTutorial();
        droolsTest.executeDrools();
    }

    public void executeDrools() throws DroolsParserException, IOException {

        PackageBuilder packageBuilder = new PackageBuilder();
        String ruleFile = "/com/rule/rule.drl";
        InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
        Reader Sader = new InputStreamReader(resourceAsStream);
        packageBuilder.addPackageFromDrl(reader);
        org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage(rulesPackage);

        WorkingMemory workingMemory = ruleBase.newStatefulSession();

        Product product = new Product();ls
                
        product.setType("gold");

        workingMemory.insert(product);
        workingMemory.fireAllRules();

        System.out.println("The discount for the product " + product.getType()
                + " is " + product.getDiscount());
    }
}
