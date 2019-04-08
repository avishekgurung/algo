package dp.general;

public class Problem008 {

  public static int paintFence(int n, int k) {
    //if there is 0 post then the ways to color it is 0.
    if(n == 0) return 0;

    //if there is one 1 post then the way to color it is k ways.
    if(n == 1) return k;

    /**
     * Consider the first two post.
     * case 1. When both post is of same color
     *    first post can be colored in k ways.
     *    second post has to be colored by same color.
     *    So the way in which the first post can be colored with same color is k * 1.
     *
     * case 2. When both post is of diff color
     *    first post can be colored in k ways.
     *    second post can be colored in k-1 ways.
     *    Hence the ways to color two post different is k * (k - 1)
     */
    int same = k * 1;
    int diff = k * (k -1);

    /**
     * As first 2 posts are already discussed, we will start with the third post.
     *
     * If the first two post are same then to make the third post different, we have
     * k-1 ways. Hence same * (k-1)
     *
     * If the first two posts are different then to make the third different, we also have
     * k - 1 ways. Hence diff * (k-1)
     *
     * So to make third post different color, we have
     *  same * (k-1) + diff * (k-1)
     *  = (same + diff) * (k-1)
     *  = k-1 * (same + diff)
     */
    for(int i=3;i <=n; i++) {
      int prevDiff = diff;
      diff = (same + diff) * (k - 1); //as stated above

      /**
       * to make the third color same, we cannot do that because of constraint that only two
       * posts can be of same color. So in this case, we cannot have to same color so it has to be
       * diff.
       */
      same = prevDiff * 1;
    }

    return same + diff;
  }

  public static void main(String[] args) {
    System.out.println(paintFence(2, 4));
    System.out.println(paintFence(3, 2));
  }

}
