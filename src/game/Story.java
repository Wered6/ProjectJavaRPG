package game;

import utils.GameLogic;

abstract public class Story
{
    public static void printIntro()
    {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        GameLogic.println("INTRO");
        GameLogic.printSeparator(30);
        GameLogic.println("W erze zapomnianych przez czas, kiedy magia była tak samo powszechna jak powietrze, które oddychamy, istniał świat pełen tajemnic i niezgłębionych mocy. Ten świat, naznaczony przez wieki konfliktów i sojuszy, był świadkiem narodzin i upadku wielkich królestw. Wśród nich, w cieniu przepowiedni i starożytnych przekazów, rodziła się legenda o Al'reku, tyranie, który za pomocą zakazanej magii i bezwzględnej siły dążył do podporządkowania sobie wszystkich wolnych ludów.");
        GameLogic.enterToContinue();
        GameLogic.println("Al'rek, niegdyś szanowany mag, skuszony obietnicą nieograniczonej władzy, zgłębił najmroczniejsze zakamarki zakazanej wiedzy. Jego serce, zatrute żądzą dominacji, przekształciło go w istotę, której same imię wzbudzało strach i rozpacz. Władając mocami, przed którymi drżała sama natura, Al'rek rzucił wyzwanie równowadze świata, dążąc do jego absolutnego panowania.");
        GameLogic.enterToContinue();
        GameLogic.println("Jednak, jak głosi starożytna przepowiednia, z popiołów konfliktu ma wznieść się bohater, którego przeznaczeniem jest stawić czoła Al'rekowi i zakończyć jego tyranię. Ten bohater, wyznaczony przez los, to Ty. Twoje dziedzictwo i odwaga są kluczami do zgromadzenia sojuszników, przezwyciężenia wyzwań i stawienia czoła mrocznemu władcy w decydującej walce o przyszłość świata.");
        GameLogic.enterToContinue();
        GameLogic.println("Tak oto rozpoczyna się Twoja podróż. Z każdym krokiem bliżej do celu, z każdą bitwą stajesz się silniejszy, gotowy by pisać historię odwagą, która przemieni ciemność w światło. Czy masz to, co potrzebne, by pokonać Al'reka i stać się bohaterem, którego pieśni będą śpiewane przez wieki?");
        GameLogic.enterToContinue();
        GameLogic.println("Twoja legenda w \"Age of Al'rek\" zaczyna się teraz. Wyrusz w podróż, która zdecyduje o losie świata.");
        GameLogic.enterToContinue();
    }

    public static void printFirstActIntro()
    {
        String actNumber = "I";
        String actTitle = "Powstanie Bohatera";
        String content = "W wiosce, nękanej przez bandytów i dzikie bestie, pojawia się nieoczekiwany bohater. Przeznaczenie wzywa, a Twoja podróż rozpoczyna się teraz. Z wielkimi nadziejami i małym ekwipunkiem, wyruszasz w świat, by odnaleźć siłę potrzebną do stawienia czoła Al'rekowi.";
        boolean isIntro = true;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printFirstActOutro()
    {
        String actNumber = "I";
        String actTitle = "Powstanie Bohatera";
        String content = "Po przemierzaniu bezkresnych lasów i pokonywaniu pierwszych wyzwań, czujesz, jak z każdym dniem rośnie Twoja moc. Pierwszy akt Twojej odyssey dobiega końca, ale to dopiero początek. Przed Tobą jeszcze więcej niebezpieczeństw i przygód.";
        boolean isIntro = false;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printSecondActIntro()
    {
        String actNumber = "II";
        String actTitle = "Poszukiwanie Sojuszników";
        String content = "Twoja sława rośnie, a legendy o Twoich czynach zaczynają przyciągać innych bohaterów, którzy pragną stanąć u Twojego boku. Wędrując przez miasta i osady, zbierasz wokół siebie drużynę niezłomnych sojuszników, gotowych podzielić z Tobą ciężar walki.";
        boolean isIntro = true;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printSecondActOutro()
    {
        String actNumber = "II";
        String actTitle = "Poszukiwanie Sojuszników";
        String content = "Z każdym pokonanym wrogiem, Twoi towarzysze stają się bardziej doświadczeni, a ich wiara w zwycięstwo jest coraz większa. Jako zespół, jesteście gotowi stawić czoła kolejnym wyzwaniom, które niesie ze sobą los. Al'rek czeka, ale nie jesteś już sam.";
        boolean isIntro = false;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printThirdActIntro()
    {
        String actNumber = "III";
        String actTitle = "Przepowiednia";
        String content = "W pogoni za Al'rekiem dotarłeś do starożytnych ruin, gdzie przepowiednia wyryta w kamieniu ujawnia sekrety Twojego przeznaczenia. Musisz zgłębić starożytne magie i odkryć ukryte moce, które pomogą Ci stawić czoła nadchodzącym ciemnościom.";
        boolean isIntro = true;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printThirdActOutro()
    {
        String actNumber = "III";
        String actTitle = "Przepowiednia";
        String content = "Przepowiednia została spełniona, a Twoje umiejętności osiągnęły szczyt możliwości. Czujesz, że nadchodzi czas konfrontacji, a aura Al'reka unosi się już na horyzoncie. Ostatni akt Twojej podróży zbliża się wielkimi krokami.";
        boolean isIntro = false;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printFourthActIntro()
    {
        String actNumber = "IV";
        String actTitle = "Ostateczne Starcie";
        String content = "Stoisz u bram mrocznej fortecy Al'reka, gdzie zło kłębi się w powietrzu. Twoje serce bije mocno, a duch bojowy Twoich sojuszników jest niezachwiany. Wszystkie ścieżki prowadzą do tej chwili – ostatecznej bitwy, która zdecyduje o losie świata.";
        boolean isIntro = true;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printEnd()
    {
        String actNumber = "IV";
        String actTitle = "Ostateczne Starcie";
        String content = "Za Tobą walka, która na zawsze zostanie zapisana w annałach historii. Al'rek został pokonany, a jego ciemność rozproszona na wiatry. Pokój powrócił do świata, a Twoje imię będzie śpiewane przez bardów przez wieki nieskończone. Ale pamiętaj, bohaterze, prawdziwa przygoda zawsze znajdzie sposób, by kontynuować swoją opowieść...";
        boolean isIntro = false;
        printAct(actNumber, actTitle, content, isIntro);
    }

    private static void printAct(String actNumber, String actTitle, String content, boolean isIntro)
    {
        String str = isIntro ? "INTRO" : "OUTRO";
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        GameLogic.println("AKT " + actNumber + " - " + str);
        GameLogic.println(actTitle);
        GameLogic.printSeparator(30);
        GameLogic.println(content);
        GameLogic.enterToContinue();
    }
}
