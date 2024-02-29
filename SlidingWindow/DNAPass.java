package SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNAPass {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int s = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());
    int result = 0;

    int[] checkArr = new int[4];
    int[] myArr = new int[4];
    char[] arr = new char[s];
  }
}
