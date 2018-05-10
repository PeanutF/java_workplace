import java.util.InputMismatchException;
import java.util.Scanner;

public class TestHorse {

    public static void main(String args[]){
        try{
            Horse horse = new Horse();
            int specification = 1;//地图的规格
            System.out.print("enter the specification of the map:");
            Scanner scanner = new Scanner(System.in);
            specification = scanner.nextInt();
            //判断地图合理性
            while (specification <= 0){
                System.out.print("please enter the correct specification(>0):");
                specification = scanner.nextInt();
            }
            int map[][] = new int[specification][specification];
            System.out.print("enter the start location(x,y) of the horse:");//输出x y（中间加空格）
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            //判断坐标合理性
            while(startX < 0 || startX > specification - 1 || startY < 0 || startY > specification - 1){
                System.out.print("please enter the correct location(x>0 && y>0 && x<specification && y<specification):");
                startX = scanner.nextInt();
                startY = scanner.nextInt();
            }
            Point start = new Point(startX,startY);//起始地点
            horse.setMap(map);
            horse.setSpecification(specification);
            //走过的路径
            horse.run(start);
            horse.printPath();
        }catch (InputMismatchException e){
            System.out.println("enter error!");
        }
    }
}
