package MergeSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyscExamSort {
    // 신체 검사 데이터
    static class PhyscData {
        String name;
        int height;
        double vision;

        // 생성자
        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.height > d2.height) ? 1 : (d1.height < d2.height ? -1 : 0);
            }
        }
    }

    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("손수경", 165, -10.0),
                new PhyscData("ㅇㅇㅈ", 170, -3.0),
                new PhyscData("ㅊㅁㅇ", 163, -7.0),
        };

        Arrays.sort(x, PhyscData.HEIGHT_ORDER);

        System.out.println("신체검사 리스트");
        System.out.println(" 이름        키       시력");
        System.out.println("------------------------------");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%-8s  %3d     %5.1f\n", x[i].name, x[i].height, x[i].vision);
        }
    }

}
