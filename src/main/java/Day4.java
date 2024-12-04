public class Day4 {
    private static final String XMAS = "XMAS";

    public static void main(String[] args) {
        char[][] mat = createMatrix(getInput());
        System.out.println("count=" + countValid(mat));
        System.out.println("count2=" + countXValid(mat));
    }

    private static int countValid(char[][] mat)
    {
        int count = 0;
        for (int i=0; i<mat.length; i++)
        {
            for (int j=0; j<mat[0].length; j++)
            {
                if (mat[i][j] == 'X')
                {
                    count += countOrthogonal(i, j, mat);
                    count += countDiagonal(i, j, mat);
                }
            }
        }
        return count;
    }

    private static int countXValid(char[][] mat)
    {
        int count = 0;
        for (int i=1; i<mat.length-1; i++)
        {
            for (int j=1; j<mat[0].length-1; j++)
            {
                if (mat[i][j] == 'A' && isValidXDiagonal(i, j, mat))
                {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValidXDiagonal(int i, int j, char[][] mat)
    {
        String a = new StringBuilder().append(mat[i-1][j-1]).append(mat[i][j]).append(mat[i+1][j+1]).toString();
        String b = new StringBuilder().append(mat[i+1][j-1]).append(mat[i][j]).append(mat[i-1][j+1]).toString();
        if ((a.equals("MAS") || a.equals("SAM")) && (b.equals("MAS") || b.equals("SAM")))
        {
            return true;
        }
        return false;
    }

    private static int countOrthogonal(int i, int j, char[][] mat)
    {
        int count = 0;
        count += checkRight(i, j, mat) ? 1 : 0;
        count += checkLeft(i, j, mat) ? 1 : 0;
        count += checkDown(i, j, mat) ? 1 : 0;
        count += checkUp(i, j, mat) ? 1 : 0;
        return count;
    }

    private static int countDiagonal(int i, int j, char[][] mat)
    {
        int count = 0;
        count += countUpRight(i, j, mat) ? 1 : 0;
        count += checkUpLeft(i, j, mat) ? 1 : 0;
        count += checkDownRight(i, j, mat) ? 1 : 0;
        count += checkDownLeft(i, j, mat) ? 1 : 0;
        return count;
    }

    private static boolean checkRight(int i, int j, char[][] mat)
    {
        int it = 0;
        while (j < mat[0].length && it < XMAS.length())
        {
            if (mat[i][j] != XMAS.charAt(it))
            {
                return false;
            }
            j++;
            it++;
        }
        return it == XMAS.length();
    }

    private static boolean checkLeft(int i, int j, char[][] mat)
    {
        int it = 0;
        while (j >= 0 && it < XMAS.length())
        {
            if (mat[i][j] != XMAS.charAt(it))
            {
                return false;
            }
            j--;
            it++;
        }
        return it == XMAS.length();
    }

    private static boolean checkDown(int i, int j, char[][] mat)
    {
        int it = 0;
        while (i < mat.length && it < XMAS.length())
        {
            if (mat[i][j] != XMAS.charAt(it))
            {
                return false;
            }
            i++;
            it++;
        }
        return it == XMAS.length();
    }

    private static boolean checkUp(int i, int j, char[][] mat)
    {
        int it = 0;
        while (i >= 0 && it < XMAS.length())
        {
            if (mat[i][j] != XMAS.charAt(it))
            {
                return false;
            }
            i--;
            it++;
        }
        return it == XMAS.length();
    }

    private static boolean countUpRight(int i, int j, char[][] mat)
    {
        int it = 0;
        while (i >= 0 && j < mat[0].length && it < XMAS.length())
        {
            if (mat[i][j] != XMAS.charAt(it))
            {
                return false;
            }
            i--;
            j++;
            it++;
        }
        return it == XMAS.length();
    }

    private static boolean checkUpLeft(int i, int j, char[][] mat)
    {
        int it = 0;
        while (i >= 0 && j >= 0 && it < XMAS.length())
        {
            if (mat[i][j] != XMAS.charAt(it))
            {
                return false;
            }
            i--;
            j--;
            it++;
        }
        return it == XMAS.length();
    }

    private static boolean checkDownRight(int i, int j, char[][] mat)
    {
        int it = 0;
        while (i < mat.length && j < mat[0].length && it < XMAS.length())
        {
            if (mat[i][j] != XMAS.charAt(it))
            {
                return false;
            }
            i++;
            j++;
            it++;
        }
        return it == XMAS.length();
    }

    private static boolean checkDownLeft(int i, int j, char[][] mat)
    {
        int it = 0;
        while (i < mat.length && j >= 0 && it < XMAS.length())
        {
            if (mat[i][j] != XMAS.charAt(it))
            {
                return false;
            }
            i++;
            j--;
            it++;
        }
        return it == XMAS.length();
    }

    private static char[][] createMatrix(String input)
    {
        String[] splitInput = input.split("\\n");
        char[][] mat = new char[splitInput.length][splitInput[0].length()];

        for (int i=0; i<splitInput.length; i++)
        {
            for (int j=0; j<splitInput[i].length(); j++)
            {
                mat[i][j] = splitInput[i].charAt(j);
            }
        }

        return mat;
    }

    private static String getTestInput()
    {
        return "MMMSXXMASM\n" +
                "MSAMXMSMSA\n" +
                "AMXSXMAAMM\n" +
                "MSAMASMSMX\n" +
                "XMASAMXAMM\n" +
                "XXAMMXXAMA\n" +
                "SMSMSASXSS\n" +
                "SAXAMASAAA\n" +
                "MAMMMXMMMM\n" +
                "MXMXAXMASX";
    }

    private static String getTestInput2()
    {
        return ".M.S......\n" +
                "..A..MSMS.\n" +
                ".M.S.MAA..\n" +
                "..A.ASMSM.\n" +
                ".M.S.M....\n" +
                "..........\n" +
                "S.S.S.S.S.\n" +
                ".A.A.A.A..\n" +
                "M.M.M.M.M.\n" +
                "..........";
    }

    private static String getInput()
    {
        return "AXSASXXMASAMXMXSASMMXMSAMXMXXMASMXMXMSMSMXMAXMSMSMSMXXMXMXMASXMASXMXSXSASXSXSSSSSSMSSMXMAASAMXXSSSMMXMMMSXSAXMASXMMXSXMAXSAMXAMXXMASMMXXSAXS\n" +
                "SXXAAMAXMAXMAAAXXMAXAXSMXAMMMMSMMMMAMAMAMSMSMXAAAAASAMMAMXMASAMXMASXSAMXMAAAMAAAAXXAAMSSMXMAXMAMAAXSASAAMMAMSAAXSASASASAMXSXMXSAMMAMAMSSMSAA\n" +
                "XXMMMAMMXMMSSMSSXXAMSMMMSMSAMXASAAMAXAMAMAAAASMSMSMSXASASMSASXMASXSAMSMAMAMSMMMMMMMXSMAASMSSMAAMMMMSASMSMSSMSMSSSXMXSAMXSAMMMAMXMXAXAMXAAMMM\n" +
                "XMXAAXXMASAAAAAMMSMMXAAAAASXSSMSSSMSMSXXSMMMXXAAAMAMXMSASAMASASXSAMXMASXMMXMASAMXXAAMMMMMXAAXSXMMMAMXMAXAAAAXAXAMASAMXMAMAMAMXXAAXMSSSSMMMXM\n" +
                "XSXSMSMMAXXSMMMSMAAMSSMMMMMMMMXMAMAXXXAXSMMSXMSMSMSSSXMAMXMAMMXXMXMMXXAMXSASXMAMXMMXXAMSSMSMMXASXMSSSMAMMMMXMXMASAMXXAMXSXSSMMSSMSAAAMXSAXAM\n" +
                "MMMXAAAMMXAMXSASXSSMMAMXXSASAMAMAMSMAMAMXAAAAAMAXAMAASMMMSMASXMAMASAMSMSASASXMXMAMXMMMMAXAMAMMMMAAMAMMXMXXXSMAXXMAMMSSMAMXXAAAMAAMMASMMAMMMS\n" +
                "AAAMMMSMSAXXAMAXAMMMSXMMASXMASXMSAMXMAMMSMMSSSMAMAMMSAMAAAMAMAXAXAXXXAAMAMXMAXSSMXAXASMMSXXAMMASMMMAMSMSMXAXSMSMSAMXAAMAXMMMMSXMXMAAAAXMSSMM\n" +
                "SMXXXXAAXMMMSMMMSMSASXMMMMSSMMXAMXXAXAXMXSAAMAMMMAMXMAXMSSMSSMXXMMSSSMSMXMAMAMMAASMMXXAXAMSMMMAXXMSXXAAAAXMMSMAMMMSMSSMSASXXAMMSXAMXSXMXAAAX\n" +
                "XMMSSMMAMMAAAAASMMMAMAXXAAAMAASMMXSMSMSAAMMSSSMSMASXSXMMXAAMAMSASAAAAAXMASXMSASMMMAASMMMAMSAAMSSSMMSSMSMXXAMXMAMSAAAAAAMAMXSXSAMMMSMMMSMSSMM\n" +
                "XMAAAASXMSASMSMSAAMMMMMMMMSSMMMASMAMAAAMXSAXAAAMSAMMMMMMMMAMAMSAMMXSMMMSASAMXMXMAMMMMASMXAMMSMXAAXAAXXXAMSXMAMAXASXSXMMMSMXXAMMMAMAASAMXXAAX\n" +
                "XMMXXMMMMMMMAMASMMSMSAAXSAMAAASAMSAMMSMSMMMSMMXMMMXAAAAAMXSMXMMSMAMMAMXMXMMMXMMXAXAXSXMAMSAAXMMSMMMSSSMSMAASXSSMMMMMMASAXSSMSMSMXSASMSSSSSMM\n" +
                "XMSSSMSAAAAMAMAMAXAASMXXMAMSMMMAXMXSXMXXAAMAXXXMASMSSSSXSAXMSAAAMAXSAMSMXSXSXAAMMSMMAMXXAXMSSMAMASXXAMXXMSMMAAAXXXSAAXMAMAXAMASAXAXMMXMAMMAM\n" +
                "MXAAMASXSSSSXMSSMMMAMXSSSXMASAMXMMSMMMSSSMSMSXMSAXMAAAAAMAMAXMSMSAXSAMASAAAXMMXSAAXASXMXSXMXAMXSAMSMMMMXXMMXMXMMMMMMSMMXSMMSMAMAXXSMXSMMMMAM\n" +
                "ASMMMMMXMAMXAAXAAXXAMMXMAMSAMXMASXAAAAAMXMAXMAXMMSMMMMMMMXMXMMXAMXAMAMASMMMMXAAMXSMMXSASMMSSXMMMAXXMAAXMXMSAMASXMAAXMASAAXMAMXMXSAMXAXMXXMAS\n" +
                "XXAXSAMXMMMSMMXMMSMMSSSMSMMASMSASXSMMXMXXXAMXMXXSAMXMXXMSSXMASMXMXMMMMAMAXAXMAMSAMAXAMMAAXXMMSMMSMMSSXMMAMMASASASXMSXAMASMXMSAAAMMMMMSMASAMM\n" +
                "SSSMAAMXSAAXASXSAXAXAASAMXSAMXMXXAXMSSSMSSSMMAMXSXSASXAMAMAMMMASXXSAXSMSMMXMASXMAMAMXSSSSMXAAAMAXAMXXSSMASXMMASAMXASMMMMMXAXSMSAMXSAMXMAXAXM\n" +
                "AAMMSXMASMMSAMXMASXMMMMMMXMXSXAAMSMMXAAAAAAMAXMASMSAXSAMXMAMAXMAAAMAMAAAXMAXAMXXSSMMAAAAAXXMMSSXXAMXMAMSAMAMMAMMMMAMAMSMASXMSXMXMXMAMMMXXAMS\n" +
                "MXMAMAMAMSAMXMXXMMMASXSSXXMSMMMXMXAMMSMMMSMMSAMXXAMXMXXMMSMSMSAMXMAMMMSMSSMMASAMMAMMXSMSMMMSAMXMSSMMAXMMXSXMMXSASMMSMMAMAXAMXASMXASAMSASXSXX\n" +
                "XXMSSMMMMAXMASMMSASXMAAXXXXAAAXMXSAMMXMXMAMMAAMASXMXXMAMAAXXAAXMXXAXAXAAXAASAMAXSAMSAMXAAAAMXSXXAXAXSMMMMMASXMSASXAAASXMMMMMMMMAXMASXMASAMXM\n" +
                "SMMAAMSSMMMSASAASAMMMMMMMMSMSMSMAMMMXAMXSASXSSMAAAMAAMSMSSSMMMMMMSASMSMSMMXMASXMMXMXAMMSSMSSMMMMMSMMAAAAASAMXAMSMMMSXMAMAAXAMXXMMXMAXMSMMMSX\n" +
                "SAAMSMAAAAMMSSMMMAMMXAXAAAAXAXAMXSASMSMXSASAAXMXXAMXSAAAAAAAXXXAAXAAAAMMMXXXXAMXXSAXMSAMAAAMAAXMXAASXSSSXMASMMMAXSAMXSMMSXXAXASAXXXSMXXSAAAM\n" +
                "SSMMMMSSMSSXAMAASXMXXXSMSSSSSSMSMAMXAMXMMSMMMMMMSSMAXMMMMSMMMSSMXSAMXMXSMSMMMASMMMASAMASMMMXXMMMSSMMAXAMXSMAMASMSMASAMXMAASMMAAMSSMMSMAMMMSA\n" +
                "XASXAAMMAMXMAMMMXMAMXMSAMAAAXXXAAAXMSMAMMXSAMAMXAASAMXSAXAMAXXXAMAXMMSAMMAAMSMMAAAMMASMMAMXSXSAMXMMMMMSMMSMASXMMAMAMMMAMXMASMXMXAASAAMSMMAMM\n" +
                "SAMSMMSMAMAMMSXMSAXSAAMAMMMMMSMSMSXAAMAMAAXMXAMMXXMMSASASMSSSMMAMMSAAMASXSSMAXSSMMXMXMMMXSAAMSXMAMXSAAXXAXMAMMXMXMXSXSXSAMXAMAMMAAMXSAAAMSSX\n" +
                "MAMXSAMMXSXSASXAXXMXMMSSMXXASAAMMMMSMSSSMSSSSSSMSAMAMXMASXAMAAAXAXXMXMAMMXMMAMXAMMXASMSMAMMSMMXMXSASMSSMMXMMSMSMSAXSAMASXSMMASXMSSSXXXSSMMXM\n" +
                "SXMASXSAXXXMASMMMMMXSAMAXMSMSMSMAXAMAAAXAXAAAAAASAMMXSMAMMMSSMMMSAMSMMSSSMSSSMSMSMSAMAAMXSAMXXSAMMAMAMXAXSMMAXAAAXMMAMMMMSAXAMAMAAXASAMXMXMA\n" +
                "AAMXXXMAMSAMXMAAAAXAMAMMMASASAXMXSXMMMXMSMMMMMMMMAASASMSMSXMASXAXAAAAAAAXAMAAAXXAAMAMSMMMMMSMAMAXXXMAMXSMAXSMMMSMSMSMMSAASMMASAMMSMXMXMAXMAS\n" +
                "SMSSMXXAMMAMXSMSSSMSSSMXMSMMMMXMXMASMSMAAAAXMAXAXXXMASAMAAXSAMMMSXSSSMMSMSMSMSMMMSMAMAAAAAXXMXSSMMMSXSAMAXMASXAAAAAAAAXMXMASASASAMXSXMMXSMSX\n" +
                "XMAXXASMSXXMASMAMMAXAXMAXAXAAAAAXMXMAAMSMXAXXAMSXSXMAMAMSMMMMMSAMXAAAXXMAAAAAAXSXXMASXSMMSMXMXMMAAAMASMXSXAASMMMSMMMSASMSSMMASAMASAXAXXASMAX\n" +
                "SMSSMMSAAXMSAMMAMXMMSMXMMMSSMSMSSXSXMXMXASASMMAMAMXMAXAMXXAMAAMASMMMMASMSMSMSMSMMMXXSMMMXAXAMAMXMMSMAMXAMASMMASAMMSMAXXAAMXMAMAMXMMSMMMAXAMS\n" +
                "SAAAAAMXMSXMASXXXAXSXMASAXXMAXXXMAMAMSXMAAAXASAMAMASMSSSSSSXMAXAXAXMMAMXAAAAMXAAAAAMXMAXSASMSMMAASXMASMMMAMXMASASAAXXXMMMMXMXMAMAXMMMASMSMMS\n" +
                "MAMSMMXAMMXMSMAMSMMSASASMSSXSXAMMAMAMAAMXMASAMXMAMXAXAAAAAAAMMMSXMMAMASMMSMSMMSSMSSMAMAMSASAAAMSSMASASAMSSSXSXMAMXMMMMASAMMMSMMXMSMXSASXAXAX\n" +
                "XAXXXAMMXAASAMXAASASXMASAAMXMXMAMAXMMSSMAXMAXMMSSSXXMSMMMMSMMAAMASXMSMMXAXMMAXMAXAAMSMSMMAMMMSXMAMAMXXAMAAXXMXMASMXAXSAMXSAAMMSSMMMAMASMMMXS\n" +
                "SMSXMSSMASXSSMXSAXXXXMXMMMSAMAXXSMXMMXXMAXSXSXAAMAMMXAXAXXAAXMMSMMAMXMSMXMASXMSSMXXMAXXXMMMXMMAMAMSSMSSMXSMMMXXAMAMSXMASAMMMSAAAAASASASAASXA\n" +
                "XMAMAMAAXMAXASAMXMXSMSAMMAMAXAXMAMAASAMXSXXAMMMMSMMASMSMSMMSMAMXXSXMAMMAAMAMAAAXMSSSMSASMASASXSMMXMAMAXASAMXAMMMMSMXASMMMXSAMMSSSMSASXSXMSAM\n" +
                "AMASMSAMMSXSXSXASMAAASASMMSMMAXSAMSSMAMAMMMMMAXMAXAMAXAMAXAMXXAMMMMMAMMSSMSSMMMMAAXAMMMXSMSASAAAXSSMMXSXSAXXAXAMAXASAMSXXAMAXXAAXXMAMMMMMXAS\n" +
                "XSAMXSXSXXAMASMXAMXSASAMAAAXXAMMSMXMMXMAXAAMAAMSXMMSSMMMASMSMSMAAAAMSXXAMXMAMMSSMSSXXAXMMXMAMXMSMMAASMMASMMMSSMSAXAMSMMXMXSAMMMSMMSAMAMAMSMA\n" +
                "XMASMXAXMMAMAXMSSMMMXMAMMMSSMASAAMAMMASMSSSMMSMSAMXAMASMXSAAASXMSXSMMXMAMAXAMAAAMAXASMMAMSMSASAXASXMMAMAMAXAMAMMASMMXMASAAMAMXSXMASMSSSXXAAM\n" +
                "MSMMAMXMMSAMXXXAAMAMASMMMMAMXAMXMSASXMSXAMAAAXAMXSMMSAMMAMXMSMAMMMXXXAMSSMMSSMSSMMMMMMASXMAXAMSSXMXMSMMASAMXXAMXAAAMXXXMAMSAMMXMMMSAAAMMMXSX\n" +
                "MASMMXAAASASAMMSSMMMASMAAMASMSMXXMASAASMMSXMMMAMAXAXMASMAXSMXMXMXAXMSSMMAMAAAMAXMXMXAAMXAMAMXSXXXAXMASXXSMAMSMMMMSSMSXMMMASMSAMXSAMMMSMAXSMX\n" +
                "SAMSAXSMMMAMXMAMAAXMASXSSSXSXMMASMASMMMSXAXMSSSMSSMMXAMMMMSAMASXMSAAAXAXAMMSMMSSMAMSASXSXMXSXAXMAXMMAXSAMXXMAAXXXMMXXAAXXAMXMMMAMASAMXMXSAAX\n" +
                "MASMMXXAMXSMSMSSMMXSXMAMMAMXAMSAXXAMAXAMMMSMAXMAMMXAMSSMXAMXMXMAAXMMMSMMSSXMMXMAMAXAMXAMXXAMXMXMASMXAXAMXMSSSXMMXAXSSSMSMSXMXAMMSAMAXMASMMMM\n" +
                "MSMAXSXXXAAAAAAMMXAMMAMSMSSMMMMSSMMSSMSXSAAMMMMSMMMSMMAAMSMSMMMMMMMXMAAAXXAMXAMAMSSMMMSSSMXSAMAXXAAMSMMMMXXAMXASMMMAAAAXAAASMMSXAXSXMAXAMXSX\n" +
                "MAXAMXMMMSXSMMMMSMAMMAXSAASAMXAAMAMAAAXAMXMMMAXAAXSMASMMXMAXAAAAMAXAMSMMSMSMSXSASASAAXAAAAXXMXMMSAMXXAAXXXMAMMXMAASMSMMMSMXMAASMAMXMASAMXAXS\n" +
                "SMSXMAAXXAAMMSAAASAMSMSXMMSXMMMXSXMXSXMMMXSSXSMSXMASAMAXAMXMASMSMXSMXAMAMAMAAASXMASXMMMSMSMXSAMXAXXASXMMMSMAMMSSSMSXMAMXAXAXMMMAMAXAAXMXMASA\n" +
                "XMAMSASXMMSXASMSMMMXAXMASXMAXXMASXMAXXMXAXXAAXAXSSXMMSSMMMAMXMXXXXMXSASXMAMMMXMAMXMAMSMMAMXASASXMXMASXAMAAXASXAAXAMMMAMSMSSXMASXMXAMXSXMSXMM\n" +
                "XMXMXAXXXMXMMMAMAMXSMXXAMASAMXMASAMASAMXASMMMMAMAMXAAAXAASASXMASXMMASMMMSMSXXASXMXSMMSAMAMMMSAMMXAXAMXMMSSSXSXMMMSMAXMXMAAAASASMSAMXMAMAAAMX\n" +
                "SMMMMMMSXSAMXAMMAMAMXSMAMAMXAXMASAMAMXMAMXMASMMMAMSMMXSSMSMSAAMXMAMAXAXAXXMASMSASXAXASMMASAAMAMSSXSASMMAMXAMMMXXAXMSAMAMMMSMMASAMXXXXXASMSMM\n" +
                "XXAAAAASMMMSMMSSSMXSASMSMSMMMMMMSAMMSMXAXMXAMAXMXXMAXAMXASASAMMMSSMMSSMSMMSAMMSAMMAMXSASXMMXXXMAAMSAXASXSMXAASAMXSAMXSASAXAMMMMAXMXMSAAMAAAA\n" +
                "SSSSXMXSAASXAXAMXAAMXMAMAAMAMSAMXXMMAXSXSMMSXXMMMMSAMSSMXMASXAMXAAAAAAAAXAAASAMXMSMXMSMMSSXSMAMMMMMMMMAAAXXSASAXSMMXXSXSXSXMASMMMMAMXMXMXMMS\n" +
                "AAAAXMXSXMXMSMMSMSMMMMAMXMMAXSAMXXMSMMXMAXAXASXSAAMAXXAMXMXMASMMSSMMSSSMMSSSMAXMXAAAXMMASMAMSAMAMSXSAXMMMMMMASMMXMXMMSXMASAMASAAASASAMXSSMMX\n" +
                "MMMSMSASXSXAXXXAMXAAXMXSAMMSXXAAMXXAMXMXMMSSMAASMXSMMXSAMMAMXMXAMAMXAAAXAXXXMSMASMSMSAMXMMXMAXMASMASXSXSAAXMXMXAMMAAAMASMMSMMSXMMSXSASAMXMAM\n" +
                "XXXAAMAMAMASMMSMXSSMMSAMXMAXXAMXAMSSSSMXXAAMXMXMAASAMXMASAMSMSXMSAMXMXMMSMXSMMAXMAMXSXMAXSSMASXMMMXMAXAXSMMSAMXMAMXSMSAMAAXMXSMMMSASAMMMMXAS\n" +
                "XXMMSMXMSMAMAMAXMAAMAMMXAMXSSSSSSXAAAAXMMMMSAXMAMXSAMMSAMMXSAMMMMXSASMXMXMAAAASMMAMAMAMSSMAMASASXSMXSMSMMXXSASMSSMAXAMXSMMXSAMASXMAMSMAASMMS\n" +
                "XMXMAXAAXMAMXSAMMSMSSMMSASMXAAAAXMMMSMMXASXSXSAAXMMXMAMASXAMAMMAMMAAAXASAMXSXMMXMXSMMAMXAMXMASAMAXXMXAXAXMASXMAAAMAMAXXMAXAMASAMXMMMMSSXMAMX\n" +
                "MSASASMMMASAAMMXXXAMAAASXSMSMMMMMXXXAXASMSAXASMSAMMMSXMASMMSMMMAMAMXMSSSSSXAMSXSMASMMSXSAMSMMMAMAMSAMXMSMAAXMSMSSMMSMMMMMMMSAMASXMSXAXMAXSMS\n" +
                "AAAXXMXXSAMXXXMASMXSMMMSASAXXXSXSSMSAXMSAMXMMMXXAASASAMASAXAMSSSSSXMXXAXASAMXXAAMMSAAXAMAMXSAXXMAXXXXAXAASMMAXAMAMASXSAAAAXMAMXMAMXMMSMMXAAA\n" +
                "MMMMASAMMASXMMSMMAASAAXMAMMMMAXAXAAMAMMXMSAMXMXMMMMASAMXSXMMSAAMAMXAMMXMMMSXAMSAMXXMMSASXMAMXSSXSAMXSMSMMMXMSMAMAMMSASXSMSMSMMSSSMXSMSASXMMM\n" +
                "XAXSAMAXSAMMAMAAMSAMAMXMMMMMSAMSMSMSXXXAXSXSAMMXSXMAMXMASAMXMMSMMSXSSSXMAAAMAXMAMAXSASAMMMMSMMXAMXSXAMXMAMXAXSAMASXMXMAXAMAAXXXAXXXMAMAMXXAX\n" +
                "MMMMAMXMMXSSSSSSMMSXAMAAAAAMMASXAMAXMMSSMSMSASASMAMSMAMXXAXAMXXXAXMAAMMXMSSMXXXMMMSXASAMXSAAAMMMMAAMAMXSASMSASXSXMMMMSXMASAMXXMXMSXMAMAMXSSS\n" +
                "AXSASAMXMXMMAMAMXAASMMSSSSSSSMMMSMXMAXAXSMASAMMAXAMASMASMMMSSSMMASMMMMMAAMXMMMXXAXXMXMMXAMXSSMAMXAMXMAXXAXAMXSMMAXAAAXXMXMMXMXMASXMSSSMXAMXX\n" +
                "AMXAMXAMMXMMAMAMSAMXMAAXXAXMMAAAASXSXMMMMMMMXMXMSSSMSXAMAAMXAMXMASXXXASMSMSAAAAMXSMSMMXMXSAMAMXMMMXMMSSMAMXMAMASAMSMSSSMSMMASXMMSAMXMAMSMSSM\n" +
                "MAMSMXSXMASXXXAMAMXMMMSSMMMSASMSSSMSAAMSXSASXSAXMAAXMMSXSMSMAMXSMMMMMMSAAAXXMMMSAXMAAXMAAMMSAMMSAMAMXAAMSMSMXMAMXMAAMAMMAASMSAXASAMMMAMAAAXX\n" +
                "XSAASAAASAMAMXSSMMASMAXXAAAXAMXXXXASMMMAASASAMSXSMSMAAXXMAXMAMXMAAXAAMMMMMMXMAXMMMSMSXSSMMXMXSAAMSSSMSSMAMSAXMXMASXSMASXSMMASXMXSAMASXSMMMSX\n" +
                "AASAMXSMMAXXXAMAMSASMMSSSMSSMSSSMSMSAMXMAMMMAMMXMAMAMXSXMAXSASASXMSSMSAMMASMSSMAAMXMAMAMXXAMSAMXXAAAXMAMAXMAMSASASXAMAXXASMAMAAXSMMMMAMAAXMM\n" +
                "MAMXSMMXMSSSMXSAMMXXAAAXAXXAAAAAAMXMASMXMMASMMSMMAMAXAXASAXMASASAMXAXMAXSASAAASXXMMASXSMMSMSXAMXMMSMMMASMSMMMSAMAMMSMASMSMMASXSXMASAMAMASMSA\n" +
                "XXMAXAXAAMAMAAMXMAMSMASMSMSMMMSMSMXMAMXAXMASXAAAMXSMMMSAMXSMMMMSAMMMMSAMMMXMSMMSMASAMAXSAAXAXAMMMXMAMSAMXAMAAMXMAMAMAXXXAASXSAMXMASXSXSXXAXS\n" +
                "SAMXSSSSXMMMMSSMXMMAMXXAAAXMAXXMAXXMASXMSMAMMXSSMAMXAMXMMASMMSASMMAAMMXXASXXMAAASAMAMAMSSMXSAMXMAASAMMMSSSSMSXXMXSAMXMMSMMMMMXMASMXMAMXMMSMX\n" +
                "SXXXXAXAASXMXMAMAXSXMMMMMXMSXXAXXXMMASAAAMXXXXAAMMXMSMSAMMXSAAMMASMSXMASMSAMSMMMMMSAMAMXAXXXSMAMXXXXXXXXAAXMXXSMAMAMAAAASXXAMMMMSAMSMAAXSAAX\n" +
                "XAMMMMMSMMAMMSAMMMSAMXMMXXMXMASXMMSSMSMMMSMASMSMMSXMMAMXXMAMXMXSAMXMXMASAXMMAAXAXXMASXSXMMMSASXSSSMMSMSMMMMMXAXMAMAXSSMMASXMXSASMMMAMSMXSMSM\n" +
                "MMMSAAAAXSAMAMASXAXAMAMSSSMXAMAAAAAAXMAXMAMXAAXMAXAMMXMSSMMXSMXMASASASAMMMMSXSSMSMSMAMSAMXXSAMXAAAAAAAMAMMAMMMMSAMMXMAMXMAXSASMXAASAXAMAMAAX\n" +
                "AAAMSMXSXSASXSSMMSMMMMSAAAXAMXSSMMSXMXMASXSMMSMSXSSMSXAXAASAMXAXMXMXASMXSAMSAMAAAAAXMASMMMMMAMMMSMMXMSXMMSASAXASMMMASASMXMMMAXXSSMSMXAMMSSSS\n" +
                "SMAXXMMXXSXMASAXAXASAMMMSMMMSAMXXMAMSMSASAMAAMXMAMAAXMXMMAMXSSSSMSSMMMAASASMSSMMMSMSXMSXMSASAMXXMAXAXAASASXSASXMAASMSASMXXXMAMMXMAXMSSXMAAXX\n" +
                "AMMAMXMMASAMXXMMMXMSASAAAXXMAXMMMXMXMAMAMXMMMSMMAMMMMMXSXXSXMAMXAAXAXXMASXMAXXAAXAMXAXMAAMXSMSMAXASXSMMMASAMXMAMSMSAMXMMSSMMXSMAMMMMAMASMSMS\n" +
                "XSMMMMSAAMMSSXMASXXSMMMSXMASMSMASAXAMSMSMSMAAXAXXSXAAMAMAXSMMAMMMMSSMXSAXXMMMSXMXSXSSMSMMSMMAAXXMXSAAXXMXMASAMAMAAXAMXAXMAASAMMXMAXMASXMAXXA\n" +
                "AAAXXAXMMMXAAASASAMXSXXMASASAAXMSAMMSMAAASMMSSSMAXMXXMAMAMMASAMXXMAMXAMMSMSMASMSXMAAAAXMXAAXSMSMMSMXMMMSXMAXMSSSMMSAMSSSSSMMAMAAMXSSMSMMMMMM\n" +
                "SSMMMMSMAXMMSMMASASAMMMSMMMMXMXXMAMSAMSMSMAXMAAMMMSXMSSSXSXMSXSSMMASMMMXAAAMXMASAMMMMMMSSSSMXXXAMAMXMAMMAMXMMAMXAXXAMXAXAAMSSSSXSSMMAMXAAAAX\n" +
                "AXAAAAAXXSMXXMMAMXMASAAAAASMSSSMMAMXAXXMXMXMMSMAXAMXMAAAAMAXSXAAXXAMAAXSMSMSMMAMMMAMAAXXAAXASXSMMAMXMXMSAMMXMASMSMSSMMMMSMMAAMAXXAAXMASMSSSS\n" +
                "MSSMSSSSMAXAAXMASASXMMMSSMSAAAAXMAXMMMMSMSMMXMMSAXSAMMXMXXAAMMSMMMASAMXXAAAAXMASXXAMMSSMMMMMSAASMSMASAAMASMASXMAMXAXXXXAXAMMMMMMMAMMXXXMMXAA\n" +
                "XAXXMAMXAMMMSMXAMMSMMMAAAMMMMSMMSSSSMAAAAAASAMAXAMSASAXSMSMSXAMSSMMMXMXMSMSMXSMSXSSSXAXMAXSAMMMMXAAASMSMMMMAXAMXMMMMMSMMSSMXMAMAAMMMXSASMMSM\n" +
                "MMSMSASMSXAXXXMMSAXAAMXSMMAXXAAMXMAAXMAMSXXMASMMXMXAMAXMAXAAMSAAMMAXAMXAAXAAASXMXAAXMSMSSSMAMMAMSAMXSAMXASMSXSMXMASAAMAMXMASXMMXSAAXXMAMXAMX\n" +
                "XXAAXSAAAASXMXAAAXMMMSXAXSAXMAXMAMMMMSAMMMXMAMXXXMXSSSXMSMAMSMMASXMSMSMSAMMMMMAXMSMMAAAXMAMAMSAMMAMXSXSMMSAMXXXASASMMSAMAMXMAAAAMXMMSMSMMSSM\n" +
                "ASMMMMMSMXMAAAMMSMSMAMMMMMASASASXMASASXAAASXSAMMMAXAAAXSMSXXXAMSAMXAXAXMASXAXSXXAAASXMXMXAMXXXAMSSMMMAXAMMXMAMAMMASAXSMSAXAXXMMXXAMMXAAAXAMA\n" +
                "MMASXMMAMASXSMSXXAXXAXAAXMASMAAMASXSAXMMSMXAMMSAAAMMMMXMASXXMXMXMASASXXSAMXSXSSSXXAMXAMSSMSSSSSMAAAXMAMSXMMMSSMMAAMMMXAXASXSASASXSMSMSMSMSSS\n" +
                "AMAMAASASXSMXAXAMAMMSSSSSMASXMAMXMMMMMAAAMMMMASMSMSAXXMMXMXXMAMXXAXXMAXMASXMAMASXXSASMMAAXAAAAAASXMMMAMXAMSAMAXSXSMXSMSMMMMAAMASAXAXMASXAMAM\n" +
                "MMSSSMMASASAMAMXMAMAMAMAXMXSXXMXMXAAAMMMMXAXMXSAXXSAMAASMMMMMAXXMAXMASASAMXMAMAMMXXAAMMSSMMXMSMMMAAAXSSSXMMASAMSAMMAXAXMXAMMMMMMMMMMSXSMMSMS\n" +
                "SAMXMXMMMAMSMXSXMAXXMAMAXXAMXXSAASXXMMAMXSXSAXMASMMSMSMMAAAXSSSXSMMMAMXMASXSXMXSMAMMMXAAMMSMXMASXXMSSMAMMAMXMASMAMMMMSMSSMMSXXAAAXMASAXAXXAA\n" +
                "MXXMXMMMMXMASMMMXMSXSAMXSSXSAAMMMMSAMSMMXMAXXXXMMAAAMXAMSMMMMXAXXAAMASMSMMMXAMXAMASXSMMXXAAXAMXAMXMXAMAMXSMMMMAMAMAAAAAXAXMAASXXXSMASMSMMMXM\n" +
                "SMXSAAAMSSMSAMAAASAMSASAAAAMMSSXSMMSMAXAMXMSMXSMSSSSXMSMXASMSAXMSSMSASMAAMAMXMXMMMMAXAMAMSSSXSAMAAMMSMAXAMAMXMASMSSSSXSMMMMSXMAMSAMXSMMAAAMX\n" +
                "AMASXSMSAAMAMSMMMMAXXAMMMMMMAXXAMAAAMMMSMSMAAMSAMMAMMAAMSMMAAXMMXAAMASXMSMMSMAASASMMMXMAMXAMASMMXXSAMMSMASAMSSMSAAAXAAXASAMXAMXMAASAMXSSMSSM\n" +
                "MMAXAMXMXMMAMMMSSSXMMSMXMSMMMSXSMMSSSXMAAASMSMMAMSAMMSMMAAMMMSAMXMMMMMXMAAAAMSMSASAMSSSSSMAMASMXSAMMXAAMMMAMAAXSMMXMMXSXXAXSAMXXXMAXXMAXAAXA\n" +
                "XMMSMMASMSSMXSAAXAXMAXAMXXAAASXMAXAMXMSMSMSXMASMMMXMXAXSSSMAXXXAMXAXXAMSSMMXXXXMMMAMSAAAXXAMXMAAMAMXMSMXXSXMSSMMAMMAMAMMSMMXMMMSAAXXXAXMMMSS\n" +
                "MMAAASASXAXSAMMSSMMSAMXMMSSMMSASAMXXMASAAASAMMXXSXMMXXMAMXMXMMMXMSXSMMMMXSMXXMMXXMAMXMMMMSXSSMMMXSMXMMAMMMMMAMASAMSAMASMAMMAXAAXMASMMSSXXXXA\n" +
                "MSSMMMMSMMMMMSAXAAMMMXAXAMMMMSAMXXXXAMMSMMSAMAMXMASXSSMSSSMASASAMMMMXMAMAMXMAMAAMSAMXSXXXXAAXAXXAXAMXMAMXAAMAXXMMXSAXAMXAAMXMMSXMMXAXASMASMS\n" +
                "MAAXXAMSASASXMXSSXMASMSSSSMAMMAMXSSMSXXXMMXAMMAAMAMAAXAAAXMMSAMMMAXAASAMASAXAXMAMAAXAMAXXMSMSXMAMXAMSSSSSMMSSSMASASXMSXSSSMSXAXMSMSSMAMMMMAM\n" +
                "MSSMSMMSAMASAMXMASMXMAAMAAXMSAMXAAAMMSAMXSSMMXSMSMMMMMMMSMSXMMMXSAMSXSMSMSMSMMMXSSXMASMMXXAXXAMAMMMMXAXAMXMXMAMAMMMMAMAMAAAMMSMMAAMXMAXAXMAM\n" +
                "AAAAXXAMXMAXAMXSAMXMSMSMXMASMAMMMSXMMMMSSMAMSAMXMMSAMXAXAAXMASXXAMAMAMXSXMASMASAMXXMAXAAXSMSSXMAMAAAMXMMSMSAMAMSMSXXAMXMSMMMAAASMSMMSSSMMSAS\n" +
                "MMMSMMXSAMSSMSMMSSXXAAAXMXMMSMMAAXMAMAAXASMMSXMXXAXMMSSSMSMMXMAMMASMMMAMAMAMMAMASASMSSMMXSAAXASASMSMSAAXAAASMAMMASAMSSMAMSXMSSMMAMXMXMAXMSAX\n" +
                "SAMXXAASMSXAASXAXMASMSMSMAXXAMMSMMSSSMXSAMXAXAMAMXXSAAAAMXMASXSAXAAAXMASXMXSMAMAMAXXXAXSAMXMXXMAXAAASXSMMSMXMXXMAMAMAAMXMXXXAMMMSMMMMSSMMMSM\n" +
                "SSSMMMMSXMXMMMMMSXAAMAXAMSXMXSAAAAAAXXXMAXMASMMASAAMMSSMMMAMAAMMMXMAMMMSXMXMXMXMMSMMSMMMAMSMSMSSMMMMMMXMAXXAASMMXSMMMSMMMMMXMMMAMAMMAXAAAAAX\n" +
                "XXXAASASASXXXXAXMMMSSMSSXXAXAMMSMMSXSAMXMMSAMXMASMSMMMAMXXAMMXMASXSSMSMSXSAMSMSMAAXMAMXSAMAAAAAXAMASAMXMASMMSMAMXMASMXXXAAXMXMASMSMMSSMSMSSS\n" +
                "MMMSMSASMMMAMSSXSXXAMXXMASAMXXAMXAMAXMASMAMMSXMASXAAAXAMXSXXSASXSAAXAAAMASMSAAAMSMMSASASXSMSMSXSAMXMASAMASASAMAMXXAMAMSSSSMMAMMMAMMMAAXAAXAM\n" +
                "AMXMAMAMXAXAAXMAMXXMMMSMAMASAMSMSASMMXMAMAMMSAMASXSSMSMSAMMMSASAMMMMSMSMAMXSMSMXMMASAMXMASXXXAAMXMXSSMMMSSMMMSSSMMSMSMAAXAMSASXMSMSMSMMMXMSM\n" +
                "XSAMAMMMSMSMSSMSMMSXAAXMAXXMASMASAAAXXAMSXSASAMASXMAXAMXAAXAMXMXMASAMAXMASXMAMXSASASMMSXASMMMSXMAMMMAAXMXSXSXAMAAAAAAMMSMMMMASXAAAXMXASXSMMS\n" +
                "XMASXMAMAMXMAAAAAMXMMMMMXXSSXMMAMXMMMMXMAMXMSMMASXSXMMMSSSMMSASXSASAMXXSASMXMXAMAMXXXMXMXMASAMASXSASMMMMAMXAMXXSMSMSXSSMMASMAMXSMSMMSAMAAAXA\n" +
                "XSAMXSXSAMXMSSMXSMAXAXSXSAMXMSMASXSAXMAMXSMXSAMASMMASAAMAMXXSAMXMXMAMMMMMMMAXMSMXMXSSMMAMSSMAXAMMSASXSAMASXSXSAXAXAMAMAMSASXSAXXXAAAMMMSMMMM\n" +
                "MAXAAXXSXSAAAAMAMMMMXSAASXMAMMXXSASAXSASASAMSAMAMXMAXAMMAMMAMAMASMXMAMAAAASAMAAMMSAMAAASASMSSMXSMMMMMSXSAMXAAMMSSMSMAMAMMASAXMMMSSMMXMAXAMAX\n" +
                "AMMMASAXASMSMSMASAMAXSMMMASXMASMMMMAMXAMASMAMXMXSMMSSSSSSMMAMSMAAAMAMSSMSXSMXSMSAMASMMMMXSAAMAMAAAMAAMMMMSMMMMAMAAXMAMASMAMXMAAMMMAMSMMSMSSS\n" +
                "XXMXMAMMMSAMXAMXMAMSMMAASMMASAMXAAMXMMSMMMXMSSXXMMAAAAAAMASXXMMSSMAXMAAMXXMMAXAMAXAMXAXSXMMMMXASXMSSMXAAAAMXXMAXMMMXXSASMAMSMSXSXSAMAAAXAAXA\n" +
                "SMMMMAXAMMXASXSSSMSMASXMSASAMASMSMXMAAAASMMAAMAMXASMSMMMMXMSAXXAAXSSMMSMXAAMASASXMSMMMMSMMMMSXMXXXXAASMSSMMSXSSSSXSAAMAMXSSMAMAMXSXSXSMMMMSM\n" +
                "AAAAXASMSAMXAAXXAXAXMMSMSAMSMXMAAMSMMMSMMAXMMMMXAMXXMXXXSXASXMASMMAAXAAASMMSMSAMXMAAASASAAAAMXMMMMMMXMAAMXASAMMAMAMMMMMMAMAMAMAMMXAMAMXXAAXX\n" +
                "MSSXSAMXMASMMSMSMMMSMMAXXXXMMAMXMAAAAAAASAMXMASXMSSMXMXMXMAMAMMXXSXMASMXMXAAAMXSASMSMMAMSMMMXAMAAXAMAMMMXXAMAMMAMMMAMASXAMAMSSSMMMAMXMASMMSM\n" +
                "XAAASXMXSAMXXAAAXAXAASMSAMAMMAMXXSSSMXXMMMMSMAMAXAAAAAASASASAMXMASMXAMXAAMSMSMASMSAMMMSMMMMXSASMSSXSASAMXMSSSMMAMAMXXAXSMSMXXXMAXSASXSXSAAAM\n" +
                "AMMMMAXXXAXXXMSMSSSSMMXAAMAXSXSMXAAAAASMSAAMMXXMMXXSSSMSAMXSMSMMAMAASMSMSMXAAMMMMMMMAAAAXAAASMMAAXMSAMASXAXAAXMSSSSSMMXXMAMMMSSXXSASAMAXMMSA\n" +
                "MMMSSMMMSSMMSMXXXMAMAAASXMMMSAAXXMSMMMAASMSMSAAMMSXAAXMMMMAXMAXMMXSSMMAXXXXMMMMAMAAXMSSSSMMMSASMMMMMXSAXXSMMMMMAMXAXASXXXAXAAXMXMMMMAMMMSSMA\n" +
                "AAAXAAAXAAAAAAXSAMAMXAMXXXXAMXMMMXXXXXMMMAAXMMSAASMMMMMASMMSAMXMAMMAMSMSSMMMAAXAMSXSAAAMMASASMMAMXXAMMMMXXMASAMASMMMAMAASXSSSSXXMASMXMXAXAXX\n" +
                "MMMSSXSMMSAXMMMXAMXSSSMMMMMMSASASMMSSMXXMMMSAAMMSMXXAASMSAASAMXMAXXAMXXAAAMSXSSXMAAMMMSMSAMMMXSAMMMXXAXSMSMASASASAXXXMMMMMAXAMXMSAXSASMMSAMM\n" +
                "SAMXXAXAXXXSSSMSSMAMAAAAAAAMSASAMSAAASMSMAAXMASXXMASMXSAMMMSXMSSMSSXMAMMMSMMAMMMAMXXXAXMMAMMMAMMXAAMXMMAAAMMSXMXSXMMXXASMMMMAMAXMASAMXAXXMSA\n" +
                "SMSSMSMMAAMAMAAAXMAMMXMXXMMMMAMAMMMMSAMMXMXSAMXXAMAXMASXSAMMMMAXAAXAMXMSAMAMXMAMXSMSMASMSSMAMMSSSSMSAXXMSMSMSXSAMAMSAMXXAAMSASXMMXMMXSMMAMAX\n" +
                "SAAXAMASXXAAXMMMSSSSSMSSSMMAMMMXMMSMXASAASXMASASMMASMMMAMXAAMXXMMMSSMAAMASXMSMSMXMASMAMMAMSMMAAMAAASAXSAMAXAXAMMXAMXASMSMMXSAMMSSSMSAMMSSMXS\n" +
                "MMMSMMAMAMSMXAMXAAMAMSAAAXSAMMSAXXAASMMXXSAMXMXXAMASAXMXMSMMSMMXSXAXXXMSXMMXAAXMAMSMMSSMAXSXMMMSSMMMAMMAMXMAMSMMMAMMMMAAXSXMSMMAAAAMMMAAAXAM\n" +
                "SSMAAMSMMMAASXSMMSMAMMMMMMMASASXSSMMMMASXXMMMMMSMMXMAMSAMMSAAMMAMMXSXSXSASXSMMMSASMXAMXMSSMMXSAMAASMSMSXMSMMMMASMSMMMMMMMMAAAMMMSMMMSSMSSMMS\n" +
                "XAMMSMAAXSMXAAMMMMMASAXXASXMMASAMXMAMMASMMSAMAAAMMMMSMMAXAMMSAMASMMMASASAMAMAAASMSMMMMAMMAMAAMASMXMAXXAAAXSXAMSMAMSMASXMAXAXMASMAMXAAAMMXMXM\n" +
                "SMMMMMSSMXMXMXSAMXSASXMMXXAAMXMXMAXAXMXXAMSASMSMSAAXAASMMMSAXMSAMXAMXMAMAMMSMMMSAMMASMMMMXMSSSMMMAMSMMSMMAASMMAMAMASASAXSAMXXAXMASMMXMMXAMAS\n" +
                "SAAXMAMAMAMXXMSXSXMASMMMSSMMMAMASXSMSMSMSMMMMMAASMSMMMMXAMXAXXMAMSSSXMXMXXMAMMXSMASASASXSMAXAMXASXMAAAXAXAMMMSMSMSMMMMAMXAXAMMMSAXAXSMXSMSAS\n" +
                "SSMSMMSAMSAMXXMMSAMSMMSAAMMXMAXMSAAAAAAXMAMSAMMMMAXAMASMSMMMMXMAMAAMXMXMXXMAXSAMXXMAMAMAAMXMAMSAMXMSXMMMXXXSAAXAAAXAAMSMSSMSMSMMAXSMSAASXAMS\n" +
                "MAMXAAMXMXMAMMAAMAMXXAMMXMASMMSXMXMMMSMXSAMSXSSXMASMSASAMXAMSSSMSMXMASAMXASAMMAMMAMSMXMSMMMMXMAAMXMAXSAMMMMMSSSMSAMMMSAAXMAMAMXMSMMASMMMMXSM\n" +
                "SXMMMMSXMASMSMMSSXMMMMSSMMMSAASMMASXMAXXMAXMMAXASAMMAMMAMSMMXXAXXXASASMSAAMASXMMSAAAMXXXAAXMASMXMMMAMMAXXAAAMMXXMAXSMMMSMMAMAMSXMAMAMASXMSSX\n" +
                "SMXAMXXXMMSXAAAXMASAAAAXAAXMMMMAXAXAXXMAMXAAXAMXMASAMXSXMSXSASXMAXXSAMASXXSAMMAAMASMSSMSSMXSASXXSAMXMSSMSMSSSSSSMSMSAAAMXMASAMSAMAMASAMAMAXM\n" +
                "SSSSSSMMSAMMSSMXSAMMMMSSSMSXMMSMMMMMMSXMAMMXMMSXSXMASAAASXAAAMMMSMMMAMAMAMMMXSMMSMXXXAAXMXAMXSAMSAMXMAMXAXAAXXAXAMAMSMMMASASXXSAMAXASXMXMAXA\n" +
                "MAMAAAAAMAMMMAAAMAXXXAXAXXAAAAAAAAASAMASAMSASXAAMMAMMMMXMMXMSMXAMASMXMASXMASAMAMXMAASMSMSMXSAMAMXAMXMSSSMSMSMMMMMMAMXXXSASAMMMXAMASMMMXSAXSS\n" +
                "MAMMSMMMXSMSMXMXSAMSAMMSMSMMMSSSMSMSASMMAMSASAMXMAXMAMSASMSAAMMMSAMXAXASMSASXSAMSXSMSXMASXMMXSXMXSAMXAXAXXMAAAAAAMASMAAMXMAXAMSMMXSAAMAAXMAX\n" +
                "SXSXXXMXMXASASMXMMXSAMXAAXASAMXXXMASAMXMXMMXMXXAXSMSAMSXMAMXASMASASMSMMSAMASASASMAXAXMMAMAMAMMMMAMSAMXSXMMAMSMSSMSASMAMAMMSMMXAAAASXMMMXXXXX\n" +
                "AAXMXMAAXMAMAMSAMXXMXMSMSMMMAXXSAMAMASXSSSSMSMXMSMAXAMXAMXMXMXMAXMMAXMAMMSMSAMMAMMMSMAMAMAMAMAAMASXSMMAMXXMXXAAAXMMSASXSASMAXSMSMMSXMASMMSSS\n" +
                "MSMSAMSSSMXMXMSMMMMSMMAAAAXMMMMAMMAXMMAXXAAAXAASAMMSMMSXMMMAXAMMSMMXMMMSMSASMXSAMXAAXMSXMSSMMSSSXSAXMAMSASXSMMMSMXAMAAAASAMSMSAAMAMASXSAAAXS\n" +
                "XMAMXMAXAMXXXASXMAMAAXMSSMMXAAXXMSMXSMXMMSMMMSXSAXXAAAXAXAMSSMSXAAAASASAAMAMMMSASXSMMXMMMXAAAXAXXMMMMSMXAMAMXSAXXMASXMMMXMAXASMSMASMMASMMMMX\n" +
                "SMSMMMSSMMSSMMMXSSSSSMMAXASMSSSMMASASMXAAAMXAXMMMMSSSSXSMSSMAMMMMXSAXMMMSMAMAAMAMAAXAAAXMAMMMSASXMMAXAAMSMSMAMXXAXAAMASAMXAMXMAXMMXAMAMXXMAM\n" +
                "AAAMSAMAMAXXXAMXAAAAMXMSSMMAAAAASASXMASXSSSSMMMSAMXAAAAMMMAMMMSSXMMMSMSAMXASMXSAMSMMSMSMMXSAXMAMAASMSMSMMAXMMSASXMXMSAMASMASMMMMAMSAMASMSMSA\n" +
                "MSMSMASAMXSXSXSMMMMMMAAMAMXMMMSMMMSAMAMMAMAAXASAAXMMMMMMASAMXXAXSXAXAAAAMSXSAASAMXAAXSMXAASMSMAMXMXAAAAAMAMAXMASMAAXMASAMMAXMAXSAMSXMASMAAMM\n" +
                "XXMXMXMASAAMAMXMXXMASXSSSMAXAXXMMMSMMASXMMSMMSSSXMASXMASXMASAMXSMSAMAXSAMXMMMMSSMSMMSMXMMMSSSXXSXXMSMSMSMAMAMAMXASMXSAMMSMXSMAMMAXMSAMXMMMMX";
    }
}
