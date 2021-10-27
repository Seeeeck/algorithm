package m10.d12;

import java.util.List;

/**
 * 宴请员工 每个员工有其开心值
 * 宴请规则:不能宴请某员工的直接下级员工
 * 问如何宴请 开心值最大 求最大值
 */
public class MaxHappiness {


    private static class Employee{
        private int happiness;
        private List<Employee> employees;
    }

    private static class Info{
        private final int headMaxHappiness;
        private final int noHeadMaxHappiness;

        public Info(int headMaxHappiness, int noHeadMaxHappiness) {
            this.headMaxHappiness = headMaxHappiness;
            this.noHeadMaxHappiness = noHeadMaxHappiness;
        }
    }

    public static int maxHappiness(Employee boss){
        Info process = process(boss);
        return Math.max(process.headMaxHappiness,process.noHeadMaxHappiness);
    }

    private static Info process(Employee x){
        if (x.employees.isEmpty()){
            return new Info(x.happiness,0);
        }
        int hasHead = x.happiness;
        int noHead = 0;
        for (Employee employee : x.employees) {
            Info info = process(employee);
            hasHead += info.noHeadMaxHappiness;
            noHead += Math.max(info.headMaxHappiness,info.noHeadMaxHappiness);
        }
        return new Info(hasHead,noHead);
    }
}
