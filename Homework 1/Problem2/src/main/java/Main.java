import org.apache.commons.cli.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Options options = new Options(); //specify all options that a command can have

        options.addOption("a", false, "Total Number of files");
        options.addOption("b", false, "Total Number of directories");
        options.addOption("c", false, "Total unique Extensions");
        options.addOption("d", false, "List all unique Extensions");
        options.addOption("e", true, "Total number of files for a specified Extension");
        options.addRequiredOption("f", "Folder Path", true, "Path to the folder");


        try {
            CommandLineParser parser = new DefaultParser(); //Parse through each command line argument
            CommandLine cmd = parser.parse(options, args);

            System.out.println(cmd.getOptionValue("f"));
            // Get the Folder Path
            FileAnalytic FA = new FileAnalytic(cmd.getOptionValue("f"));

            System.out.println(Arrays.toString(cmd.getOptions()));
            if (cmd.hasOption("a")) {
                System.out.println("Count files : " + FA.getCntFiles());
            }
            if (cmd.hasOption("b")) {
                System.out.println("Count folders : " + FA.getCntFolders());
            }
            if (cmd.hasOption("c")) {
                System.out.println("Count of unique Extensions : " + FA.getCntUniqueExtensions());
            }

            if (cmd.hasOption("d")) {
                System.out.println("List of unique extensions ");
                System.out.println(Arrays.toString(FA.getUniqueExtensions()));
            }

            if (cmd.hasOption("e")) {
                String ext = cmd.getOptionValue("e");
                System.out.println("Total number of files for extension " + ext + ":" + FA.getCntOfExtension(ext));
            }

        } catch (ParseException e) {
            //HelpFormatter formatter = new HelpFormatter();
            //formatter.printHelp( "ant", options );

            System.out.println("Usage : Main [OPTION] -f <Path of the folder to walk through>");
            System.out.println("-a, --total-num-files               The total number of files\n" +
                    " -b, --total-num-dirs                Total number of directory\n" +
                    " -c, --total-unique-exts Total number of unique file extensions.\n" +
                    " -d, --list-exts List all unique file extensions. Do not list duplicates.\n" +
                    " --num-ext=EXT List total number of file for specified extension EXT.\n" +
                    " -f=path-to-folder Path to the documentation folder. This is a required argument.");
            System.exit(0);
        }
    }
}
