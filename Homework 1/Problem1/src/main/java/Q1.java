import java.util.Arrays;

class Q1
{
    public static void main(String[] args) {
        FileAnalytic FA = new FileAnalytic();
        System.out.println("Count files : " + FA.getCntFiles());
        System.out.println("Count folders : " + FA.getCntFolders());
        System.out.println("Count of unique Extensions : " + FA.getCntUniqueExtensions());
        System.out.println("List of unique extensions ");
        System.out.println(Arrays.toString(FA.getUniqueExtensions()));
        System.out.println(Arrays.toString(FA.getCntEachExtensions()));
        //System.out.println(FA.totalExtCnt);
    }
}