package CK;

// Logger
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Options
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionTestProgram {
    private static Logger LOG = LogManager.getLogger(OptionTestProgram.class);

    // Options
    static final Options options = new Options();
    static Option help = new Option("help", "print this message");

    final boolean isHelp = false;

    public static void main(String[] args) {
        LOG.info("JSONManipulator started");
        options.addOption(help);

        // Create a CommandLineParser to parse the command line arguments
        CommandLineParser parser = new DefaultParser();
        // Create an instance of itself to not have the functions static
        OptionTestProgram Main = new OptionTestProgram();

        try {
            // Parse the command line arguments
            CommandLine line = parser.parse(options, args);

            // Check if the "help" option is set
            if(line.hasOption(help)) {
                Main.printHelp();
            } else {
                // TODO: IMPLEMENT
            }

        } catch (ParseException exp) {
            // Handle parsing errors
            LOG.error("Parsing somehow failed.  Reason: {}", exp.getMessage());
            Main.printHelp();
            System.exit(0);
        }
    }

    private void printHelp() {
        // HelpFormatter is used to print the help information
        // It formats and prints the usage information for the command line options
        HelpFormatter formatter = HelpFormatter.builder().get();
        formatter.printHelp("Command line syntax:", options);
    }
}