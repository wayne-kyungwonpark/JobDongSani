package programmers.exercise.graph;

import java.util.*;

public class NumberOfRooms {
    public static void main(String[] args) {
//        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
//        int[] arrows = {6, 4, 6, 0, 1, 2, 4, 2, 4, 4, 6, 6, 0, 3};
//        int[] arrows = {6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0};
//        int[] arrows = {5, 2, 7, 1, 6, 3};
        int[] arrows = {6, 5, 2, 7, 1, 4, 2, 4, 6};
//        int[] arrows = {2, 7, 2, 5, 0};
        System.out.println(solution(arrows));

//        Set<Segment> set = new HashSet<>();
//        Segment s1 = new Segment(new Point(0, 1), new Point(1, 0));
//        Segment s2 = new Segment(new Point(1, 0), new Point(0, 1));
//        set.add(s1);
//        set.add(s2);
//        System.out.println(set.size());
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());

    }

    // 방향에 따른 x, y 좌표 변화량
    private static final int[] xDiff = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] yDiff = {1, 1, 0, -1, -1, -1, 0, 1};

    public static int solution(int[] arrows) {
        Map<Point, Set<Point>> graph = new HashMap<>();
        Point prev = new Point(0, 0);
        for (int i = 0; i < arrows.length; i++) {
            if(!graph.containsKey(prev)){
                Set<Point> value = new HashSet<>();
                graph.put(prev, value);
            }
            Point present = new Point(prev.x + xDiff[arrows[i]], prev.y + yDiff[arrows[i]]);
            graph.get(prev).add(present);
            if(!graph.containsKey(present)){
                Set<Point> value = new HashSet<>();
                graph.put(present, value);
            }
            graph.get(present).add(prev);
            prev = present;
        }

        // 노드 중에 다른 두 개의 노드로 만들어진 선분 사이에 있는 노드를 없앰 (기하적 의미의 vertex만 추려냄)
        // (노드 별로 연결된 간선을 확인하여 해당 노드가 다른 노드 두 개로 이루어진 직선 위에만 존재한다면 vertex에서 제외한다.)
        ArrayList<Point> nodes = new ArrayList<>();
        for(Point point : graph.keySet()){
            nodes.add(point);
        }
        for(Point point : nodes){
            if(!graph.containsKey(point)){
                continue;
            }
            if(graph.get(point).size() != 2){
                continue;
            }
            // point에 연결된 간선이 일직선인지 확인
            Point[] points = new Point[2];
            int index = 0;
            for(Point p : graph.get(point)){
                points[index++] = p;
            }
            Point p1 = points[0];
            Point p2 = points[1];
            // 일직선일 경우 graph에서 해당 노드를 없애고, 해당 노드에 연결된 간선끼리 직접 연결시킨다.
            if(ccw(p1, p2, point) == 0){
                graph.get(p1).remove(point);
                graph.get(p1).add(p2);
                graph.get(p2).remove(point);
                graph.get(p2).add(p1);
                graph.remove(point);
            }
        }

        int verticesNum = 0; // vertices 갯수
        int edgesNum = 0; // edges 갯수

        // 노드가 아니지만, x자 형태로 간선이 만들어지면서 만들어내는 새로운 vertex와 edge 고려
        // 간선의 모음 만들기
        Set<Segment> edges = new HashSet<>();
        for(Point point1 : graph.keySet()){
            for(Point point2 : graph.get(point1)){
                Segment segment = new Segment(point1, point2);
                edges.add(segment);
            }
        }

        ArrayList<Segment> edgesForLoop = new ArrayList<>();
        for(Segment segment : edges){
            edgesForLoop.add(segment);
        }

        // 간선끼리 교차하는지 여부 판별
        // x자 형태로 겹치면 새로운 vertex가 1개 추가, edge는 2개 추가된다.
        for(int i = 0; i < edgesForLoop.size(); i++){
            for (int j = i + 1; j < edgesForLoop.size(); j++) {
                Segment segment1 = edgesForLoop.get(i);
                Segment segment2 = edgesForLoop.get(j);
                if(!segment1.equals(segment2) && segmentsIntersect(segment1, segment2)){
                    verticesNum += 1;
                    edgesNum += 2;
                }
            }
        }

        // 그래프 내에서 실제 vertex와 edge 수를 추가한다.
        verticesNum += graph.keySet().size();

        edgesNum += edges.size();

        // 오일러 정리 (평면에서는 V - E + F = 1)
        return 1 - verticesNum + edgesNum;
    }

    // 선분 클래스
    private static class Segment{
        Point p1;
        Point p2;
        public Segment(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || getClass() != o.getClass()){
                return false;
            }

            Segment segment = (Segment) o;
            return (this.p1.equals(segment.p1) && this.p2.equals(segment.p2)) || (this.p1.equals(segment.p2) && this.p1.equals(segment.p2));
        }

        @Override
        public int hashCode(){
            return Objects.hash(p1, p2) + Objects.hash(p2, p1);
        }
    }

    // 점 클래스
    private static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || getClass() != o.getClass()){
                return false;
            }

            Point coordinate = (Point) o;

            return this.x == coordinate.x && this.y == coordinate.y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }
    }

    // 세 점의 일직선 확인을 위한 함수
    private static int ccw(Point p1, Point p2, Point p3) {
        int tmp = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
        tmp -= (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);

        if (tmp < 0)
            return -1;
        if (tmp > 0)
            return 1;
        return 0;
    }

    // 두 선분의 교차 여부 확인을 위한 함수 (꼭지점 겹치는 경우 제외)
    private static boolean segmentsIntersect(Segment s1, Segment s2){
        int ab = ccw(s1.p1, s1.p2, s2.p1) * ccw(s1.p1, s1.p2, s2.p2);
        int cd = ccw(s2.p1, s2.p2, s1.p1) * ccw(s2.p1, s2.p2, s1.p2);

        return ab < 0 && cd < 0;
    }
}
