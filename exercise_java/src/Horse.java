import java.util.ArrayList;

public class Horse {

    ArrayList<Point> path = new ArrayList<>();

    int map[][];

    int specification;//地图规格
    int times = 0;//走过的次数
    int flag = 0;//四面都不能跑

    public void setMap(int[][] map) {
        this.map = map;
    }

    public void setSpecification(int specification) {
        this.specification = specification;
    }

    public void printPath(){
        for(Point point : path)
            System.out.println("(" + point.x + "," + point.y + ")");
    }

    //注意值传递和引用传递
    public void run(Point start){//递归，原理是图的深度遍历
        int startX = start.x;
        int startY = start.y;
        int avail_point[][] = {//马可以走的点（负数坐标没有排除）
                {startX - 1, startY - 2},
                {startX - 2, startY - 1},
                {startX - 2, startY + 1},
                {startX - 1, startY + 2},
                {startX + 1, startY + 2},
                {startX + 2, startY + 1},
                {startX + 2, startY - 1},
                {startX + 1, startY - 2}
        };
        map[startX][startY] = 1;
        path.add(start);
        times ++;
        for(int i = 0; i < 8; i ++){
            if(times == specification * specification || flag == 1)
                return; //满图的时候返回

            //avail_point中的第i组点
            if(avail_point[i][0] >= 0 && avail_point[i][0] < specification && avail_point[i][1] >= 0 && avail_point[i][1] < specification &&
                    map[avail_point[i][0]][avail_point[i][1]] != 1){
                run(new Point(avail_point[i][0],avail_point[i][1]));
            }

        }
        map[startX][startY] = 1;//没有完全遍历则回溯
    }
}

class Point{

    int x,y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

