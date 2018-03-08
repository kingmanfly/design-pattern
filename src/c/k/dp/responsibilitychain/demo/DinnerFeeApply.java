/**
 * 申请聚餐费用的管理
 * 申请聚餐费用的大致流程一般是，由申请人先填写申请单，然后交给领导审批，
 * 如果申请批准下来，领导会通知申请人审批通过，然后申请人去财务领取费用，
 * 如果没有批准下来，领导会通知申请人审批未通过，此事也就此作罢。
 * <p>
 * 不同级别的领导，对于审批的额度是不一样的，比如，项目经理只能审批500元以内的申请；
 * 部门经理能审批1000元以内的申请；而总经理可以审核任意额度的申请。
 * <p>
 * 当某人提出聚餐费用申请的请求后，该请求会经由项目经理、部门经理、总经理之中的某一位领导来进行相应的处理，
 * 但是提出申请的人并不知道最终会由谁来处理他的请求，一般申请人是把自己的申请提交给项目经理，
 * 或许最后是由总经理来处理他的请求。申请人只要直接与项目经理交互就可以，其余的工作在黑盒中，
 * 究竟流程是怎样的，最后是由谁审批通过的，申请人无需关心。
 */
package c.k.dp.responsibilitychain.demo;

/**
 * 抽象处理者角色类
 */
abstract class AbstractHandler {
    //持有下一个处理请求的对象
    protected AbstractHandler successor = null;

    /**
     * 取值方法
     */
    public AbstractHandler getSuccessor() {
        return successor;
    }

    /**
     * 设置下一个处理请求的对象
     */
    public void setSuccessor(AbstractHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理聚餐费用的申请
     *
     * @param user 申请人
     * @param fee  申请的钱数
     * @return 成功或失败的具体通知
     */
    abstract String handleFeeRequest(String user, double fee);
}

/**
 * 具体处理者角色
 */
class ProjectManager extends AbstractHandler {

    @Override
    String handleFeeRequest(String user, double fee) {
        String str = "";
        //项目经理权限比较小，只能在500以内
        if (fee < 500) {
            //为了测试，简单点，只同意张三的请求
            if ("张三".equals(user)) {
                str = "成功：项目经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            } else {
                //其他人一律不同意
                str = "失败：项目经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        } else {
            //超过500，继续传递给级别更高的人处理
            if (getSuccessor() != null) {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }
}

class DeptManager extends AbstractHandler {

    @Override
    String handleFeeRequest(String user, double fee) {
        String str = "";
        //部门经理的权限只能在1000以内
        if (fee < 1000) {
            //为了测试，简单点，只同意张三的请求
            if ("张三".equals(user)) {
                str = "成功：部门经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            } else {
                //其他人一律不同意
                str = "失败：部门经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        } else {
            //超过1000，继续传递给级别更高的人处理
            if (getSuccessor() != null) {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }
}

class GeneralManager extends AbstractHandler {

    @Override
    String handleFeeRequest(String user, double fee) {
        String str = "";
        //总经理的权限很大，只要请求到了这里，他都可以处理
        if (fee >= 1000) {
            //为了测试，简单点，只同意张三的请求
            if ("张三".equals(user)) {
                str = "成功：总经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            } else {
                //其他人一律不同意
                str = "失败：总经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        } else {
            //如果还有后继的处理对象，继续传递
            if (getSuccessor() != null) {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }
}

public class DinnerFeeApply {
    public static void main(String[] args){
        //先要组装责任链
        AbstractHandler h1 = new GeneralManager();
        AbstractHandler h2 = new DeptManager();
        AbstractHandler h3 = new ProjectManager();

        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试
        String test1 = h3.handleFeeRequest("张三", 300);
        System.out.println("test1 = " + test1);

        String test2 = h3.handleFeeRequest("李四", 300);
        System.out.println("test2 = " + test2);

        System.out.println("---------------------------------------");
        String test3 = h3.handleFeeRequest("张三", 700);
        System.out.println("test3 = " + test3);

        String test4 = h3.handleFeeRequest("李四", 700);
        System.out.println("test4 = " + test4);

        System.out.println("---------------------------------------");
        String test5 = h3.handleFeeRequest("张三", 1500);
        System.out.println("test5 = " + test5);

        String test6 = h3.handleFeeRequest("李四", 1500);
        System.out.println("test6 = " + test6);
    }
}
