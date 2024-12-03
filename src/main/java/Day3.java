public class Day3 {
    public static void main(String[] args) {
        String input = getInput();
        System.out.println("total=" + getTotal(input));
        System.out.println("totalWithConditional=" + getTotalWithConditional(input));
    }

    private static int getTotal(String input)
    {
        int total = 0;
        int i=3;
        while (i < input.length())
        {
            int first = 0;
            int second = 0;
            // mul
            if (input.startsWith("mul", i-3)) {
                // mul(
                if (input.charAt(i) == '(') {
                    i++;
                    while (i < input.length() && Character.isDigit(input.charAt(i)))
                    {
                        first = (first*10) + input.charAt(i) - '0';
                        i++;
                    }
                    // mul(10
                    if (first != 0)
                    {
                        // mul(10,
                        if (i < input.length() && input.charAt(i) == ',')
                        {
                            i++;
                            while (i < input.length() && Character.isDigit(input.charAt(i)))
                            {
                                second = (second*10) + input.charAt(i) - '0';
                                i++;
                            }
                            // mul(10,20
                            if (second != 0)
                            {
                                // mul(10,20)
                                if (i < input.length() && input.charAt(i) == ')')
                                {
                                    total += (first*second);
                                }
                            }
                        }
                    }
                }
            }
            i++;
        }
        return total;
    }

    private static int getTotalWithConditional(String input)
    {
        int total = 0;
        int i=0;
        boolean stop = false;
        while (i < input.length())
        {
            if (input.startsWith("don't()", i-7))
            {
                stop = true;
            }
            if (input.startsWith("do()", i-4))
            {
                stop = false;
            }

            if (!stop)
            {
                int first = 0;
                int second = 0;
                // mul
                if (input.startsWith("mul", i-3)) {
                    // mul(
                    if (input.charAt(i) == '(') {
                        i++;
                        while (i < input.length() && Character.isDigit(input.charAt(i)))
                        {
                            first = (first*10) + input.charAt(i) - '0';
                            i++;
                        }
                        // mul(10
                        if (first != 0)
                        {
                            // mul(10,
                            if (i < input.length() && input.charAt(i) == ',')
                            {
                                i++;
                                while (i < input.length() && Character.isDigit(input.charAt(i)))
                                {
                                    second = (second*10) + input.charAt(i) - '0';
                                    i++;
                                }
                                // mul(10,20
                                if (second != 0)
                                {
                                    // mul(10,20)
                                    if (i < input.length() && input.charAt(i) == ')')
                                    {
                                        total += (first*second);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            i++;
        }
        return total;
    }

    private static String getTestInput()
    {
        return "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
    }

    private static String getTestInputWithConditional()
    {
        return "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
    }

    private static String getInput()
    {
        return "$  mul(402,190))&<why(211,617)how()/;mul(506,313)[^^<!$#when(636,198),]mul(744,268)#&!what()&!;mul(631,641)where()@select()!@?(:;how()mul(25,288)&~^select()mul(683,657)'mul(505,315)+~:-mul(671,741)]{mul(397,54))?mul(511,935)where()select()where()-mul(525,623)mul(206,770){/}don't()from()mul(260,967)-how() -/[^(mul(500,994)!:mul(391,833)#)>who(),where(376,378)why();$mul(394,346)%:]^from()>:mul(130,944)who()>where()select()}:mul(952,439)?/how()from()^$why()do()@*{mul(557,916)&(who()mul(445,933):(,;>?mul(108,268)don't()select(574,441)-mul(132,870)from(){mul(441,660)why(),from();mul(919,820):#/%)why()*mul(194,790);#/^#select()?mul(981,514)$what(796,873)when() %from()mul(164,772):&:select()@mul(396,80)select()what()%),) mul(213,928){?who();@@mul(320,229)where(348,623)*when()when(180,565)mul(214,912)!mul(848,738)from()+):^how()-&[mul(378,433)select():%~mul(696,421)mul(364,341)?^don't()*&mul(89,441)how()select()what(),select()mul(423,822),?&(how()']what())$mul(21,844)&,select()/>^)'mul(469,230))when()where()*,#mul(569,594)why()what():{ select(200,250){())mul(661,628)#)why()from(325,19)who() mul(758,985){%&where()!how(213,616)*mul(394,768)mul(831,12)*where()>who(986,151)mul(962,504)$:<!)where()%$&when()mul(900,577)<>^[>;mul(948,363)$@;]mul(857,273) how() ,:!select(),[mul(31,766)} *mul(372,138)+,#!~(>;%mul(774,958)#}&+why()*when()mul(560,137)}mul(72,718)when()^{]':{how()/mul(985,120)@*[do()$how()mul(891,69)select()mul(546,834)@$mul(767,879)$$!/&why()?mul(876,495){^/&)who()<~]mul(911,71){?#mul(116,462);:%<^'?}~why()mul(258,286)from()^#^?how()&who()mul(97,540)select()who()do(){^~~<why(955,532)@[ how()mul(682,75)~){?where()<mul(63,26)-where()^ <^mul(336,475)&when()mul(637,386)+*when()<^]mul(846,915)!mul(795,805)$what()[~#*@:/@mul(370,651)?$select()^how()}!mul(705,839)~*;%!^+why()do()!:)[#{mul(112,21)*mul(285,252)mul(451,396){&> )'mul(57,589)when()**mul(554,575)*+^mul(856,360)mul(530,200)@/&}*where()mul(588,2)who()$]mul(604,72)who()}from(524,212)mul(250,680)<;@;@how()?#mul(555,956)%(;:+<{(who()select()mul(377,822)+when()@[&{&from();*mul(457,538)mul(52,298)who()%when()%who()how()from(9,264)mul(452,941)where()+?,-don't()when()select()<mul(956,185)^}don't(){$/~how()][ #)mul(717,593,when(64,768):what()%(mul(922,407)#why(646,569)$(~:{#mul(3,438)+/#<*select())how()don't()!where();mul(853,725)%?}/!from()<?*mul!+>$''mul(229,512){{from()what()?!'^select()mul(185,787)<*mul(688,834)  @@what(),}select()>mul(825,27))~&!;mul(796,378)*+(-select(); mul!):{!;who()$how()why()don't()select()how(451,129)]#*^mul(852,354)[mul(596,889)mul(476,207):#what()-+mul(467,323) from()why()}(}^&:mul(955,498)]{;mul(797,177)mul(321,350):mul(784,667)mul(707,927)~%#why()why()what();mul(515,511)from(589,691)mul*&[mul(884,558)/mul(824,926))+from(331,316)where()!*!:mul(938,881)]mul(287,358what()@from(226,364)+:^)-when(361,935)select()mul(324,887)@where()select())(mul(430>&][mul(381,417)}*why()why()!*#~mul(729,14)>%what()'where(){}mul(483,820)when(206,921)&when()@how()mul(608,185)how(5,376)%mul(150,182)><when()@:@mul(953,86)mul(332,881)*mul(688,895)^<select()!%<+mul(5,990)>]/!( (+mul(78,588)what()@ why()when()*+from();;mul(837,417)who()mul(786,516)'how()%:~;%]who()<mul(576,960),@why()<<+'mul(160,572)*why()where()-when(353,689){[;mul(634,920)mul(482,207)( (when()<>:;-mul(917,130)\n" +
                "why();[what()(,]mul(177,501)mul(346,27)when(428,856)who(){how()mul(513,432)what()']&where(),>?select(),do()+how()![where()mul(399,972)mul(862,828)when()?^&)mul(200,579)how()who()mul(79,535) <don't()<mul(450,265@/!mul(332,269)/select()why()-mul(436,976)&;$#-;^)what(878,202)mul(114,418}-~<! ,who()mul(394,75)<from()mul(51,262)from()#what()^*don't()%mul(133,6)mul(63,773)$%; ';@^what()!mul(142,703)where(178,667)}/(don't()how()mul(451,569)-~mul(395,265)+@>{select(684,626)){where()?)mul(52,852)&< @what()^what()]mul(807,491)&#@mul(130,14)<what()who():@mul(195,735)]when()<how()where()$,how()where()mul(310,933);[<$)mul(479,998),from()/where()@mul(583,819);select()}+$when()*mul(100,443)/$)mul(300,699)select()# #what()?:(^mul(824,627)#>mul(884,328)when()%who(255,459)mul(434,697)?how(),,*)#mul(522,208) !&/mul(296,945)-~!what()when(),,%mul(127[mul(637,905)~from()/where()/where()mul(375,117)(<;select()how():!^{mul(856from()][from()}&when(331,921)mul(873,410)'@/mul(777,739>when()!^!)mul(460,138)!'{why()<~/<mul(820,107)/<(*;& mul(887,760)/mul(701,198)+@@,{ where():mul(108,795)why()]#&don't()#+where()mul(491,644)mul(148,474)!mul(216,458)<,when()[(#mul(205^from()]@(where()?@mul(808,178)!@from();~%:]})mul(807,17)>when()when()+:(what()@)mul(97,8)mul(324,169)select()mul(396,755)!#select()^&#];when()don't()$where()/^{~{how()mul(856,118)$*who()who()#when()mul(683,431)/mul(946,398)mul(902,742)(mul(448,592)'mul(750,527)]/mul(98,232*,select()(!~/<{mul(104,754)^mul(959,509) '$~@/do()when(642,16);what() <#(+!mul(564,313)$]'mul(945from()*]!who()[%who()'*#don't()<![select()where(387,153)mul(283,666)mul(323,423)what()}where(552,799)@#what()mul(897,782)&why();where()[$#!select(){mul(965,10)?$mul(515,710)why(),!?*:mul(442,335)&<who(526,485)who()!)when():%>mul(410,907)@what()select()select()?mul(21,969)mul(942,472)' what() ?select()why()^do() /$-who()::mul(36,303)~mul(783,530)'$what()$:%?mul(74,743);~^;>do()who()who()>}mul(391@^mul(681,793)where()%!-,mul(171,461)![<<&don't()+mul(707,127)^?mul(641,578)where()how()what()what(89,960)}(]mul(431,871)mul,+mul(610,323)<why()what()mul(343,108)'mul(902,793)[where(661,90)#who())?#![}mul(535,881)mul(782,524)select()>why()why()mul(662,436)'&[^mul(397%from()>*why()%-mul(186,254)?*]!who()!select(839,279)<mul(518,739)}from()don't()(where()how()} who()~mul(394,539)^why()where()+?from()(mul(32,988)]mul(459,826)};mul(95,871)?&{select()&/;mul(626,919) '++{;from()mul(161,733),#%mul(662,339)* +mul(246,943)where()#what()what(){+,;,who()mul(555,251)what()what()%(mul(374,548)>]+select()mul(84,228)[mul(536,784)where()+*how()mul(893,249;what()(mul(917,825)mul&mul(891,755))${,#@@mul(511,464)what()where()'when()mul:who()mul(730,485)][,mul(592,512)[why(52,524),*]@select()(mul(829})' *~- [)mul(111,611)how(838,283)+#{>when()?who(764,939)from()mul(925,978)[*#who(182,485)how()select()mul(538,803)>&where()how()$what() }{mul(671,684)/why(106,337)+<#(mul(453,150)++[--from(475,981)where()&{mul(197,568) &;/mulwhy()~(@*who()/!#mul(466,89)'why(594,849)(select()( mul(30,648)what()from()(select()mul(829,947)mul(903,174),-,@select()from()select()mul(462,421)&when()!when()^%;),mul(631,703)mul(917,971)mul(473,892) don't(){/~>,why()[*mul(800,49)when()why()>%)*who())]mul(571,734)<(mul(283,803)~mul(752,111)why(); %<,(where()'&mul(393,613)mul(257,15)&mul(14,159)]mul(502,324)what()how()when(294,303)-%:when()mul(542,760)>}why(),how()mul(726,492)mul(169,827)^: ^~[ mul(859how()#how()))%@mul(564,652) mul(403,8)~mul(507,846)\n" +
                "!!{[){mul(470,989)#mul(58,989+who()?*{! [mul(498,119)%~{mul(206,173)who()from()how()}%^*;how()@mul(154,721){~mul(451,125)<-mul(386,969)!<:mul(890,369)!*{+]-,where()when()when()mul(657,994)]why():mul(898,340) how()(#who()<mul(352,838)[%)who()?how():&when(173,843)mul(21,663)how()&]^}-^>where()mul(502,23) mul(681,55$( ,mul(807,634)&${what()~what()mul(176,10)'(what()why()@~]mul(564,162)!%select()mul(526,996)!-mul(993,991)/'!?mul(118,854)?~-?mul(74,965)who())-({when()select()]mul(913,115)/[who()where()when()<%!mul, ]~#/ mul(990,573)&from()^}%$mul(226,132)mul(431,657)[who())where(690,880)',- ,mul(21,346)what()how(298,600)-mul(174,190)mul(755,197)who(){>&$what()from(853,522)mul(560,222)what()$when()[mul(933)from(881,714)[when()#~(]{mul(67,261)!mul(775,385)don't()[who()how() where()/mul(381,343)do()<}$%;<>how()'mul(460,761)(mul(83,660)[where()mul(539,808'&select()*don't()(mul(274,997)mul(274,981)}/#who()[]mul(414,738){$do()&<?:what()&why()%who()mul(638,411)&[?don't()when()+ ?> mul(672,195)'}<<mul(772,21)>@[&;select()mul(90,631) $*mul(869,108)^$+:([&#!mul(801when()~}mul(827,339)who(851,624)%&why()'when()'mul(586,599)+:'/>when()[!mul(139,133)*'!$){#~?mul(565,566)mul(618,83)+mul(765,263)why()/+how()#'{how(521,404) !mul(344,377)/select(536,767)@why()-why()'where()why(468,917)mul(302,909){:mul(632,525)from()>who()(@who()mul(383,809)<>select();when();select()who()?<do()$*mul(597,59)when()/(}mul(79,440)$mul(565,850){[how()where()mul(368,953):*}from();!,-mul(767,182)what()from()$why()when()%/&mul(410,122)%!-mul(246,726)$when()%mul(343,179) {-?why()mul(816,33),:;%#;$mul(340,519(mul(858,204)select()@!:mul(739,205)why();*]/'select()mul(891,670)]why(5,493)how()[?when(519,92)when()mul(790,933)/**>'>where()select()mul(142,6)*:(>'mul(963,13),don't() how()when()/'*mul(18,872)'mul(465,102)(#+mul(590,510! from()mul(133,919)}[,from()from() (mul(820,448)[mul(442,548)mul(977,871)}who()+select()who()mul(606,74)^:)mul>!mul(129,889)/+mul(310,726)who()from()*what()mul(49,487)/)where()]:mul(615,825)}}don't()mul(266,421)}don't()(how();select(908,869)+how()where()mul(56,163)mul(288,896)mul(872^mul(391,531)$mul(152,112)'^,from()mul(889,862)mul(562,569)^ *{';when()!(mul(236,30)>]-why()]what(83,46)when()/>how()mul(634,71)?,?{^?mul(438,21)what()mul(993,470){<[when()where()from()mul(190,720)/%where()@mul(339,904why()where()mul(123,502);) /mul(178,842)how()mul(737,234) !mul(985,241)**?~-mul(349,197)<[mul(22,535)&(&why()mul(460,416)when()&do()[how()when(), mul(250,415how()@-%*:who()*mul(181,581):@mul(353,992)*when()what()mul(247,102)where()?why(607,695)#don't()?when()from()%@<mul(624,872)+select()-^mul(589,215)mul(626,138)mul(726,746)>)from()where()mul(738,410)!where(808,172),;:*'mul/^(#mul(545,174)^:when()-$^'mul(670,694(why(117,443):mul(12,180);'@what()mul(314,309)mul(790,161)&what()where(620,466)&who()[-]*where()mul(147,178)why()^][}'~$mul(441,381){ mul(138,111)<+) <mul(795,46)mul(207,817)why()mul(360,197)?,,where()!$select()mul(908,513)'when()*&,~{:don't()mul(976,931)}$]/select()@>what()[mul(842,241):(from()how()$:mul(329,926)don't()-@$-from(245,221)]+mul(161,472):/how()mul(178,909)mul(729,950)>]mul(310,170)mul(868,180)}mul(685,89)}what(690,794)!who()!mul(670,698']>~mul(464,132)-when(827,257)?)when()#/?when()#!/usr/bin/perlfrom()--{where())what()(mul(54,26)\n" +
                "@)+mul(601,827)from()how()]'how()[where()how()]]mul(943,407)what()/why()}}mul(516,728)<-+ why() ?'mul(651,195)who(472,480)select()^{}/]mul(159,449)#{select()]>why(457,182)mul(889,383)mul(717,768)~>{select()from()~@{>'mul(25,532#}who())mul(582,481)where()>$?) !mul(232,573)mul(27,868)^~from()#where()do()how()>mul(24,375)'!;,,mul(34,942)?-mul(511,814)<:{{how()}{what()mul(369,392)mul(643,828)mul(12,913)from()~select(){ +$$mul(384,257){who()!{$ )#/!mul(607,455)how()*(( /-+::mul(747,552)mul(333,364)how()*?select(914,438)% ~,mul(257,957)do()where(){+#mul(85,930)when()^'<~^/ mul(538,737)?,%what()*-^ where()mul(959,252)mul(435,422)#where()mulwhere()mul(634,612),}{select(863,784){[do()who()}*+mul(842,759),#what());[}why(616,35)%mul(631,814);where()/)mul(768,481)>{!)>who()who()select()how()mul(432,507)&)!>{%>(mul:$?(?~@ }mul(60,211)what()what()*what()when()+];mul(960,9)- ~'mul(678]+&!mul(252,399)what()?:?} !@>[mul(510,368)mul(674,905)how()/why()^mul(763,579)mul(771,675)mul(565,944)'who(345,580)#<where(248,141)from()don't()when()who()#from()>~<mul(708,226)$select(856,127),[mul(669,13)mul(228,509)} why()mul(665,556)<]$:])@^<when()mul(820,340) mul(430,345)from()who()<why()#>!who()mul(349,192)[mul(673@#+/mul(623,920)&^where()}#who()mul(331from()$'+from()mul(906,455)select()mul(969,326)where()[$(how()[/;/-mul(342,396)>how()[*mul(319,806)~#mul(374,571)who()mul(767,564)%:-[-;@)mul(724,513)%{[$~mul(559,103)mul(495,144)who()<<why()who();)~mul(966,554)+[]select()>mul(485,851)(mul(935,69)from()mul(745,465)select();/^mul(788,539)}:/+from()select()^/~mul(385,82)mul(939,676)#!%how(){who()?mul(481,330)+[ mul(542,441)%when()!^?select()when()select()$-mul(385,342)?who()how(),who()mul(394,223)@<$@-%%&:#mul(197,885){select()when()+)when():select()[mul(753,360)why()(>;!(mul(91,833*$#mul(979,895)where()@>mul(372,24)%*mul(189,679)mul(97,308)who()>mul(657,601)->*; #&)-mul(906,401) from()(what()mul(808,51)[<{when()mul(723,974)!'@)$^who():mul(947,448)mul(440,545)'<?mul(172,802)where()mul(716,119);when())do()])where()(#where()>who()]mul(319,32)<#select(232,786)select(91,643)what()where()mul(728,960){do())^ })mul(525,770))who(),;why() #&{why()mul(695,142)@]+ )[$&*mul(558,127)how()why(),<,&how()^>!mul(126,171):)}]&don't()^'how()+*^where()where()@mul(331,359) */do()what()):why();where()>mul(715,122)when()(when()from();,)}^$don't()/where()/^mul(242,204)how()mul(910when()what()[,]/&don't()-!how()who()who();from()}where()mul(353,405)where()from()what()who()mul(562,824)mul(333,11)mul(842,629)#}+$^mul(778,805)>mul(806,747)when()!^mul(741,908)why()where()mul(110,482)>&$?mul(579,772)@}select()-mul(636,907)(mul(526,945)-(from()(*what()how():mul(166,764)?'?#mul(246how()#{mul(476,49)*:who()who():,what()-+mul(477,38)&?{;>/mul(544,656),select()*what();what(394,396)[ ?&mul(514,32){^select()@select():#]%mul(964,815)mul(562,410);when();*mul(944,789)~/^$~$-mul(750,209)* ;;how()mul(487,591);?<mul(230,18)mul(380,386),-{,@select()^mul(949,615)!how(900,63)what()+mul(557,379)]@when()] :*(:~mul(423,189)where();:when()}{[ [*mul(844,661)mul(631,480)$mul(484,570)mul(761,125~#)*@~mul(286,807)mul(715,248)&<*,'{)mul(513,214)-what(531,549)*@$where()$#) mul(420,876)*what()!mul(177,619)select()< mul(819,380)?how(): <:';mul(263,636)\n" +
                "[}[%*:mul(763,577)}<<[],@mul(416,291)}<{how()[who()):@mul(80,21)mul(147,560)who()@',what()mul(9,445)]!mul(797,562)%[$-who()mul(128,286)from(){;:mul(331,938)*why()'-[what()mul(159,223)-*where()<who(619,345)-,mul(684,152)who()mul(433,596){mul(793,372)<from(54,483)[select()[where(629,864)mul(935,16)mul(204,768)!mul(864,108)from()don't() }$mul(147,548)^mul(827,996)mul(420,422)how()what()mul(61,127)@&<'^+^>mul(245,365)[[!@),{@mul(651,974)} /<mul(333,723)+mul(198,582)mul(631,8)what(),what()]!who()how()what()<mul(21,630)where()&]~:[mul(358,326)from()+from()mul(372,505)-:do()#?what()where()mul(351,931)>]%why()&mul(809,5~*/&&why()>mul(571,244)where()#why()}what()mul(518,122)+mul(579,300)'/select(898,768)>%][$(don't(){[mul(361,809)>[>&];why()why();mul(294,704)mul(331,74)}mul(694,47)]/-mul(399,272)when()mul(104,924)when()what(347,469)>from()~^mul(642,304)when()<what(){>?why()?mul(429,733)select()#&(}&mul(125,283)select()][who():[ mul(136,666)? when()where()%what()>/how()mul(570,389):]~who()+@!}mul(713,887)?{}select()'mul(98,67)&when()do()when()>mul(536,7)*when()) !'mul(884,110)@#')mul(201,681)from()^,do()'why()#]<why()'(;+mul(593,332)]mul(180,819)/@mul(902,212)-mul(90,446)~];select()why(100,859)!don't()-'mul(893,69),}][from()don't()+(~why())mul(86,991)mul(590,379)how()mul(405,424)?:#>from()! don't()when()how()mul(420,456)%?,'mul(385?select()mul(916,632)]mul)mul(908,719)$*@ <when() <$where()mul(539,350)(+why()# +select()select()mul(405,412)'!>({/{^<when(442,660)mul(143,163) who()why()mul(140,644)mul(250,287))mul#'-when()select()how()+/$mul(822,187)mul(888,819)!<select(908,31)[$/mul(212,723)who()&]mul(372,211)mul(854,457)&;where()??}-+/mul(198,967)from()mul(669,611):what(364,527)*);[select()^)/mul(62,603)-+@mul(215,373))mul(765,970)mul(218,4)^] mul(482,465)how()$^,];from()'mul(677,699)#mul(856,173)#mul(816,115)!mul(647,891)from();<[!select()-how()mul(726,735)who(),#who()how()mul(44,988@++!~mul(298,848): /]where()^where()why()who()mul(2,969)mulwhen(779,246)where(){when()how()>how()<mul(595,699)when(){why()from()mul(270,688)^select()*!~'<}-mul(324,127)(select()-mul(354,982)]+from()&#>?!mul(980,215)>what()where()@?why()-?mul(614,656)mul(220,163)?why()how()mul(355,585)%;mul(419,411)mul(184,742)$what()>;don't()],'$(select()mul(736}when(),mul(626,880)who()*<how();*]%(mul(676,2))+%who() how()-%+<mul(366?((how()>,;mul(765,856)<<>why()mul(553,221)^!>$who();mul(813,625)>]*  how()do()]<;$<@where()select(774,55);!mul(496,557)#<>,!>)what()mul(222,55)from()who()]',what()/;where()where()mul(136,746)>(don't()]mul(970,908)select()^@)'%mul(237,672):+<@<%%-}mul(498,420)who(839,971)&select()mul(937,73)$&&from()do()mul(996,665)&where()where()%,#mul(143,849)?from(913,546)*{?([&mul(134,708)why()[,'how(166,502)select()#&mul[-mul(205,222)}select()]}( why()@(+mul(898,124?*how()@select()mul(616,898)where(705,139)]@mul(155,570)who() -$,{&mul(89,802)!+who()$do()&~]%>?{ >mul(676,57)< <from()!((*&mul(91,478)]mul(105,40)when()]'how(669,25)mul(346,548)]]]'when()>mul(738,600):mul(918,629)['when()~where()from()!;:>mul(161,824)what())from()mul(600,436)~{]what()select()!+&%/mul(996,979)}}who()] $+$mul(206,328)$^)@@/,when()}%mul(130,592)when()select()%mul(50,834)';*@when()mul(73,823)mul(865,121)\n" +
                ",^:mul(71,583)mul(316,791)from()when(){&->why()mul(495,908)@}*where(),how()%mul(645,82how(830,734)who()[mul(398,188)(%where()&do(){)from()from()who()mul(221,419)<:]$^'^)from()mul)mul(693,760)#how()>^why()why()[,'why(370,828)mul(516,571)where(425,351)<,>)mul(661,792{))$~-what())who()#[mul(325,165)[$where()%^*]who()+/mul(346,3)do()-@when() when()>+#*mul(698~ mul(248,163)/~]#{from()*mul(57,514)mul(871,508)[mul(498,284)from()who()select()when(277,99)*select()*mul(840,612)%mul(897,30)#</}^(do()<+select()@where()$when();#-mul(405,945)#why(433,827)>/mul(346,138)select()how()?)mul(354,691)?]what()don't();?;when(244,299)who();when()>mul(224,179)%]mul(50,319):mul(34,718)when()^:+where()from()'from()}mul(943,652)+/why()*why()#%don't() when()#'>+*>mul(231,697%how(175,144)mul(507,740)+~where() :from()mul(755,156)/%$)*+(who(212,81)>mul(927,385)#()do()mul(80,489):*,select()%&%where() mul(911,455who()}mul(651,799)~-why()+*mul(202,247);+%^:<mul(854,23){@#mul(961,171)where()!-mul(128,126)%%~#what()@mul(473,221)$do(){ !,&from(188,13)&!:where()mul(153,592)%select(112,432)where()mul(639,252)%]}$do()mul(504,573)how()mul(150,892)?who()+-why()%[}where()mul(602,833))-mul(53,697)%where(); /<where()$<mul(270,818)?how()}mul(185,555)/>mul(940,746),#from()when()mulwho()mul(701,602)mul(183,908)how()mul(12,827)][})how(){~when()$mul(332,704)^)when()when()mul(936,771)#where()/who()who();from()$# do()%where(){^ mul(953,541)mul(207,683),how()~%mul(336,694)why()>@<do()mul(783,475)~@mul(500,657)> *!?[from()@mul(924,686)*)%! / )why()[mul(493,198)when()>;<$how()$(]>do()(?~(!&^select()%mul(355,72)}how()~why()why()what()~'mul(936,935)&{what(803,472)from()]<who()@who()mul(17,105)where()^select()^&[<mul(869,268)what(){mul(135,402) {where()mul(732,550)where()don't()@~mul(240,194)why()~#how()mul(412,850)!$>@ ,do()@why()*why()[mul(149,595)}]mul(867,291)~&)'%<mul(330,855)(<how()%mul(712,568)(why()@when()where()~mul(913,542)$/ mul(370,272)]from()>@where()>from(455,831)%mul(646,518)% mul(522,755)];'who()from()select();what()'%mul(555,59)(how()'?[!@do():@{mul(729,27)when()]'*,/,why()where()mul(949,316)how()^who(84,611)[?:#mul(931,532)<% [where()select()@%%mul(383,846)$why()~{/+(@mul(325,437)who()>],select()#;when()%mul(601,128)<!mul(783,128)who()#select(532,884)how()]mul(928,854)<^where()/:what()(where(831,396)select()?mul(743,757)$}!{)%mul(723,274),!^{'(mul(125,779)+mul(104,510)mul(878,917)( where(389,343)%-)]mul(838,207)(^#$/</&mul(967,47)from()@{%?how()who()why()select():mul(590,941)~why()where()![-(mul(973,686)<!(,#{(/mul(787,692)~+mul(629,517)+why()-(>?mul(10,499)%mul(704,145) >mul(811,825);*{mul(539,875)mul(920,111)mul(509,272)mul(657,901)>mul(464,17)why()what()!why()*])}!mul(736,189)mul(299,45)when()select(169,279)><>[,mul(532,593){mul(627,971)how()who()how()where(291,392)/[): do()!mul(770,718)$&;!what()]?#^%mul(938,624)what():<#how()@!~mul(279,222)from()^++);:?why()$mul(98,818)$(]#{%-mul(891,49)+who(251,742)> what()where()<(mul(526,69)}%when()]/(~#do()select()**+^-from()mul(119,943)what()?from()when()*}<what()<]mul(577,966)select(){select()*['>( don't()mul(370,463)!why()>who()mul(326,383)!~how(59,628)!; %do()mul(671,969)!mul(747,375)mul(257,559)!?#!/<how(315,722)(mul(529,781)<'[%?$mul(118,474)mul(866,674)%mul(99,500)?[who()do()who(394,637)^(+ [#(?{mul(555,282){-[*@!'select()where()don't()*{what();why()&>*mul(353,892)select()why()(mul(648,3)how()don't()<~{mul(771,164)mul(576,453)$why()}-@'mul(967,581)* %{:when()where(){*<";
    }
}
