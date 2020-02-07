package niuke.p2;

public class Solution {

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5, 6, 7, 0 };
    System.out.println(InversePairs(array));
  }

  public static int InversePairs(int[] array) {
    int[] back = new int[array.length];
    return sortCount(array, back, 0, array.length);
  }

  private static int sortCount(int[] arr, int[] back, int start, int end) {
    if (start + 1 >= end) {
      return 0;
    }

    int mid = (start + end) / 2;
    int a = sortCount(arr, back, start, mid);
    int b = sortCount(arr, back, mid, end);

    int k = start;
    int i = start;
    int j = mid;
    int c = 0;
    while (i < mid && j < end) {
      if (arr[i] <= arr[j]) {
        back[k++] = arr[i++];
        c += j - mid;
      } else {
        // arr[i] > arr[j]
        back[k++] = arr[j++];
      }
    }

    while (i < mid) {
      c += j - mid;
      back[k++] = arr[i++];
    }

    while (j < end) {
      back[k++] = arr[j++];
    }

    i = start;

    while (i < end) {
      arr[i] = back[i];
      i++;
    }

    return a + b + c;
  }
}