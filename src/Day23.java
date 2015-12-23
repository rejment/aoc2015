import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author daniel.rejment@tacton.com (2015-12-23)
 */
public class Day23 {
    public static void main(String[] args) throws IOException {
        List<String> program = Files.readAllLines(Paths.get("src/day23.txt"));
        System.out.println(run(program, new int[]{0, 0}));
        System.out.println(run(program, new int[]{1, 0}));
    }

    private static int run(List<String> program, int[] regs) {
        int pc = 0;
        for (; ; ) {
            if (pc < 0 || pc >= program.size()) {
                return regs[1];
            }
            String[] instr = program.get(pc).split(" ");
            switch (instr[0]) {
                case "inc":
                    regs[instr[1].charAt(0) - 'a']++;
                    pc++;
                    break;
                case "tpl":
                    regs[instr[1].charAt(0) - 'a'] *= 3;
                    pc++;
                    break;
                case "hlf":
                    regs[instr[1].charAt(0) - 'a'] /= 2;
                    pc++;
                    break;
                case "jio":
                    if (regs[instr[1].charAt(0) - 'a'] == 1) {
                        pc += Integer.parseInt(instr[2]);
                    } else {
                        pc++;
                    }
                    break;
                case "jie":
                    if ((regs[instr[1].charAt(0) - 'a'] & 1) == 0) {
                        pc += Integer.parseInt(instr[2]);
                    } else {
                        pc++;
                    }
                    break;
                case "jmp":
                    pc += Integer.parseInt(instr[1]);
                    break;
            }
        }
    }
}
