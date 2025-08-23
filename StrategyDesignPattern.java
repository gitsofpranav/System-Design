
interface WalkableRobot{
  void walk();  
}

class NormalWalk implements WalkableRobot{
   public void  walk(){
    System.out.println("Normal walk ...");
   }
}

class NoWalk implements WalkableRobot{
    public void walk(){
        System.out.println("Cannot Walk ...");
    }
}

interface TalkableRobot{
    void talk();
}

class NormalTalk implements TalkableRobot{
    public void talk(){
        System.out.println("talk normally...");
    }
}

class NoTalk implements TalkableRobot{
    public void talk(){
        System.out.println("cannot talk...");
    }
}

interface FlyableRobot{
    void fly();
}

class NormalFly implements FlyableRobot{
    public void fly(){
        System.out.println("fly normallly ...");
    }
}

class NoFly implements FlyableRobot{
    public void fly(){
        System.out.println("No fly ...");
    }
}

abstract class Robot {
    protected WalkableRobot walkBehavior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot  flyBehavior;


    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        this.walkBehavior = w;
        this.talkBehavior = t;
        this.flyBehavior = f;
    }

    public void walk(){
        walkBehavior.walk();
    }

    public void talk(){
        talkBehavior.talk();
    }

    public void fly(){
        flyBehavior.fly();
    }

    public abstract void projection();
}

class CompanionRobot extends Robot {
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}



public class StrategyDesignPattern {
    public static void main(String[] args) {
         Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("--------------------");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}
