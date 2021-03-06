package Gobblegum_Pack_Generator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Generator extends JPanel {
    private int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private int blackBorderXSize = 0;
    private int blackBorderYSize = 0;

    private final ArrayList<Image> imagesAllGobblegums = new ArrayList<>();
    private final ArrayList<Image> imagesClassicGobblegums = new ArrayList<>();
    private final ArrayList<Image> imagesMegaGobblegums = new ArrayList<>();
    private final ArrayList<Image> imagesRoundBasedGobblegums = new ArrayList<>();
    private final ArrayList<Image> imagesTimeBasedGobblegums = new ArrayList<>();
    private final ArrayList<Image> imagesPlayerActivatedGobblegums = new ArrayList<>();
    private final ArrayList<Image> imagesAutoActivatedGobblegums = new ArrayList<>();

    private final ArrayList<JButton> buttonsClassicGobblegums = new ArrayList<>();
    private final ArrayList<JButton> buttonsMegaGobblegums = new ArrayList<>();
    private final ArrayList<JButton> buttonsRandomGobblegums = new ArrayList<>();

    private boolean classicGobblegumOnly = false;
    private boolean megaGobblegumOnly = false;
    private boolean roundBasedOnly = false;
    private boolean timeBasedOnly = false;
    private boolean playerActivatedOnly = false;
    private boolean autoActivatedOnly = false;
    private final Color buttonSelectedColor = new Color(145, 228, 255);

    Generator(){
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        calculateBlackBorders();
        WIDTH -= blackBorderXSize * 2;
        HEIGHT -= blackBorderYSize * 2;

        KeyboardListener.addKeyboardListener();
        getImages();
        createButtons();
        setAllButtonBounds();
        gobblegumSelector();
        drawClassic();
    }

    private void calculateBlackBorders(){
        double basedOfScreenRatio = (double) 9/16;
        double userScreenRatio = (double) WIDTH / HEIGHT;
        int correctedSize;

        if (basedOfScreenRatio != userScreenRatio) {
            if (Math.abs(basedOfScreenRatio - userScreenRatio) > 1){
                correctedSize = (int) Math.round((double) HEIGHT / 9 * 16);
                blackBorderXSize = (WIDTH - correctedSize) / 2;
            }
            else if (Math.abs(basedOfScreenRatio - userScreenRatio) < 1){
                correctedSize = (int) Math.round((double) WIDTH / 16 * 9);
                blackBorderYSize = (HEIGHT - correctedSize) / 2;
            }
        }
    }

    private void getImages(){
        String[] imageNamesClassicGobblegums = new String[]{
                "Alchemical_Antithesis_GobbleGum_BO3.png",
                "Always_Done_Swiftly_GobbleGum_BO3.png",
                "Anywhere_But_Here.png",
                "Armamental_Accomplishment_GobbleGum_BO3.png",
                "Arms_Grace_GobbleGum_BO3.png",
                "Arsenal_Accelerator_GobbleGum_BO3.png",
                "Coagulant_GobbleGum_BO3.png",
                "Danger_Closest_GobbleGum_BO3.png",
                "Eye_Candy.png",
                "Firing_On_All_Cylinders_GobbleGum_BO3.png",
                "Impatient_GobbleGum_BO3.png",
                "In_Plain_Sight_GobbleGum_BO3.png",
                "Lucky_Crit_GobbleGum_BO3.png",
                "Newtonian_Negation_GobbleGum_BO3.png",
                "Now_You_See_Me_GobbleGum_BO3.png",
                "Projectile_Vomiting_GobbleGum_BO3.png",
                "Stock_Option_GobbleGum_BO3.png",
                "Sword_Flay_GobbleGum_BO3.png",
                "Tone_Death.png"};

        String[] imageNamesMegaGobblegums = new String[]{
                "Aftertaste_GobbleGum_BO3.png",
                "Board_Games_GobbleGum_BO3.png",
                "Board_To_Death.png",
                "Bullet_Boost_GobbleGum_BO3.png",
                "Burned_Out_GobbleGum_BO3.png",
                "Cache_Back_GobbleGum_BO3.png",
                "Crate_Power_GobbleGum_BO3.png",
                "Crawl_Space_GobbleGum_BO3.png",
                "Dead_of_Nuclear_Winter_GobbleGum_BO3.png",
                "Disorderly_Combat_GobbleGum_BO3.png",
                "Ephemeral_Enhancement_GobbleGum_BO3.png",
                "Extra_Credit.png",
                "Fatal_Contraption_GobbleGum_BO3.png",
                "Fear_in_Headlights_GobbleGum_BO3.png",
                "Flavor_Hexed_GobbleGum_BO3.png",
                "Head_Drama_GobbleGum_BO3.png",
                "I%27m_Feeling_Lucky_GobbleGum_BO3.png",
                "Idle_Eyes_GobbleGum_BO3.png",
                "Immolation_Liquidation_GobbleGum_BO3.png",
                "Killing_Time_GobbleGum_BO3.png",
                "Kill_Joy_GobbleGum_BO3.png",
                "Licensed_Contractor_GobbleGum_BO3.png",
                "Mind_Blown_GobbleGum_BO3.png",
                "Near_Death_Experience_GobbleGum_BO3.png",
                "On_the_House_GobbleGum_BO3.png",
                "Perkaholic_GobbleGum_BO3.png",
                "Phoenix_Up_GobbleGum_BO3.png",
                "Pop_Shocks_GobbleGum_BO3.png",
                "Power_Vacuum_GobbleGum_BO3.png",
                "Profit_Sharing_GobbleGum_BO3.png",
                "Reign_Drops_GobbleGum_BO3.png",
                "Respin_Cycle_GobbleGum_BO3.png",
                "Round_Robbin%27_GobbleGum_BO3.png",
                "Secret_Shopper_GobbleGum_BO3.png",
                "Self_Medication_GobbleGum_BO3.png",
                "Shopping_Free_GobbleGum_BO3.png",
                "Slaughter_Slide_GobbleGum_BO3.png",
                "Soda_Fountain.png",
                "Temporal_Gift_GobbleGum_BO3.png",
                "Unbearable_GobbleGum_BO3.png",
                "Undead_Man_Walking_GobbleGum_BO3.png",
                "Unquenchable_GobbleGum_BO3.png",
                "Wall_Power_GobbleGum_BO3.png",
                "Who%27s_Keeping_Score%3F_GobbleGum_BO3.png"};

        int i = 0;
        for (String imageName: imageNamesClassicGobblegums){
            Image image = ImageLoader.loadImages("/Gobblegums/Classic/" + imageName).getScaledInstance((int) ((double) 160 / 1920 * WIDTH), (int) ((double) 160 / 1080 * HEIGHT), Image.SCALE_DEFAULT);
            imagesClassicGobblegums.add(image);
            imagesAllGobblegums.add(image);
            switch (i) {
                case 1, 3, 7, 9, 12, 15 -> imagesRoundBasedGobblegums.add(image);
                case 5, 6, 13, 16, 17 -> imagesTimeBasedGobblegums.add(image);
                case 4, 10, 18 -> imagesAutoActivatedGobblegums.add(image);
                case 0, 2, 8, 11, 14 -> imagesPlayerActivatedGobblegums.add(image);
            }
            i++;
        }

        i = 0;
        for (String imageName: imageNamesMegaGobblegums){
            Image image = ImageLoader.loadImages("/Gobblegums/Mega/" + imageName).getScaledInstance((int) ((double) 160 / 1920 * WIDTH), (int) ((double) 160 / 1080 * HEIGHT), Image.SCALE_DEFAULT);
            imagesMegaGobblegums.add(image);
            imagesAllGobblegums.add(image);
            switch (i) {
                case 0, 1, 15, 23, 28, 38 -> imagesRoundBasedGobblegums.add(image);
                case 2, 9, 29, 33, 35, 40 -> imagesTimeBasedGobblegums.add(image);
                case 4, 6, 14, 25, 27, 34, 36, 37, 39, 41, 42 -> imagesAutoActivatedGobblegums.add(image);
                case 3, 5, 7, 8, 10, 11, 12, 13, 16, 17, 18, 19, 20, 21, 22, 24, 26, 30, 31, 32, 43 -> imagesPlayerActivatedGobblegums.add(image);
            }
            i++;
        }
    }

    private void createButtons(){
        for (int i = 0; i < 19; i++){
            Image image = imagesClassicGobblegums.get(i);

            ImageIcon imageIcon = new ImageIcon(image);
            ImageIcon grayImageIcon = new ImageIcon(GrayFilter.createDisabledImage(image));

            JButton button = new JButton(imageIcon);
            button.setBackground(null);
            button.setBorder(null);
            button.setName(imagesClassicGobblegums.get(i).toString());
            button.addActionListener(e -> {
                if (button.getIcon() == imageIcon) button.setIcon(grayImageIcon);
                else button.setIcon(imageIcon);
                changeUsableGobblegums('C', button.getName());
            });
            buttonsClassicGobblegums.add(button);
        }

        for (int i = 0; i < 44; i++){
            Image image = imagesMegaGobblegums.get(i).getScaledInstance((int) ((double) 116 / 1920 * WIDTH), (int) ((double) 116 / 1080 * HEIGHT), Image.SCALE_DEFAULT);

            ImageIcon imageIcon = new ImageIcon(image);
            ImageIcon grayImageIcon = new ImageIcon(GrayFilter.createDisabledImage(image));

            JButton button = new JButton(imageIcon);
            button.setBackground(null);
            button.setBorder(null);
            button.setName(imagesMegaGobblegums.get(i).toString());
            button.addActionListener(e -> {
                if (button.getIcon() == imageIcon) button.setIcon(grayImageIcon);
                else button.setIcon(imageIcon);
                changeUsableGobblegums('M', button.getName());
            });
            buttonsMegaGobblegums.add(button);
        }
    }

    private void setAllButtonBounds(){
        int[] classicGobblegumOrder = new int[]{1, 4, 6, 11, 16, 10, 17, 2, 7, 3, 9, 5, 12, 14, 0, 8, 18, 15, 13};
        int xNumerator = 11;
        int yNumerator = 8;
        for (int number: classicGobblegumOrder){
            buttonsClassicGobblegums.get(number).setBounds((int) (WIDTH * xNumerator/20 - (double) 80 / 1920 * WIDTH) + blackBorderXSize, (int) (HEIGHT * yNumerator/20 - (double) 80 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 160 / 1920 * WIDTH), (int) ((double) 160 / 1080 * HEIGHT));
            if (xNumerator == 19){
                yNumerator += 3;
                xNumerator = 11;
            }
            else xNumerator += 2;
        }

        int[] megaGobblegumOrder = new int[]{0, 1, 2, 4, 7, 8, 9, 10, 12, 14, 17, 16, 18, 21, 22, 26, 27, 31, 36, 39, 41, 43, 3, 5, 6, 11, 13, 20, 24, 37, 38, 40, 42, 15, 19, 23, 25, 28, 29, 30, 32, 33, 34, 35};
        xNumerator = 8;
        yNumerator = 6;
        for (int number: megaGobblegumOrder) {
            buttonsMegaGobblegums.get(number).setBounds(WIDTH * xNumerator/16 + blackBorderXSize, HEIGHT * yNumerator/24 + blackBorderYSize, (int) ((double) 116 / 1920 * WIDTH), (int) ((double) 116 / 1080 * HEIGHT));
            if (xNumerator == 15){
                yNumerator += 3;
                xNumerator = 8;
            }
            else xNumerator++;
        }
    }

    private void changeUsableGobblegums(char type, String name){
        boolean in = false;

        for (Image image: imagesAllGobblegums){
            if (Objects.equals(image.toString(), name)){
                in = true;
            }
        }

        if (in){
            imagesAllGobblegums.removeIf(image -> Objects.equals(image.toString(), name));
        }
        else{
            if (type == 'C'){
                for (Image image: imagesClassicGobblegums){
                    if (Objects.equals(image.toString(), name)){
                        imagesAllGobblegums.add(image);
                    }
                }
            }
            else if (type == 'M'){
                for (Image image: imagesMegaGobblegums){
                    if (Objects.equals(image.toString(), name)){
                        imagesAllGobblegums.add(image);
                    }
                }
            }
        }
    }

    private void setButtonFont(JButton jButton){
        jButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        int i = 0;
        while (jButton.getPreferredSize().width > jButton.getSize().width && i < 50){
            jButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50 - i));
            i++;
        }
    }

    private void gobblegumSelector(){
        JButton classic = new JButton("Classic");
        JButton mega = new JButton("Mega");
        JButton classicOnly = new JButton("Classic Only");
        JButton megaOnly = new JButton("Mega Only");
        JButton roundBased = new JButton("Round based");
        JButton timeBased = new JButton("Time based");
        JButton autoActivated = new JButton("Auto activated");
        JButton playerActivated = new JButton("Player activated");
        JButton generatePackButton = new JButton("Generate");

        classic.setBounds((int) (WIDTH * 5/8 - (double) 90 / 1920 * WIDTH)  + blackBorderXSize, HEIGHT / 8 + blackBorderYSize, (int) ((double) 180 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(classic);
        classic.setBackground(buttonSelectedColor);
        classic.addActionListener(e -> {
            classic.setBackground(buttonSelectedColor);
            mega.setBackground(UIManager.getColor("Button.background"));

            drawClassic();
            repaint();
        });
        classic.setFocusPainted(false);
        add(classic);

        mega.setBounds((int) (WIDTH * 7/8 - (double) 90 / 1920 * WIDTH) + blackBorderXSize, HEIGHT / 8 + blackBorderYSize, (int) ((double) 180 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(mega);
        mega.addActionListener(e -> {
            mega.setBackground(buttonSelectedColor);
            classic.setBackground(UIManager.getColor("Button.background"));

            drawMega();
            repaint();
        });
        mega.setFocusPainted(false);
        add(mega);

        classicOnly.setBounds((int) (WIDTH / 4 - (double) 325 / 1920 * WIDTH) + blackBorderXSize, (int) (HEIGHT / 2 + (double) 50 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 300 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(classicOnly);
        classicOnly.addActionListener(e -> {
            if (classicGobblegumOnly){
                classicGobblegumOnly = false;
                classicOnly.setBackground(UIManager.getColor("Button.background"));
            }
            else {
                classicGobblegumOnly = true;
                classicOnly.setBackground(buttonSelectedColor);

                if (megaGobblegumOnly){
                    megaGobblegumOnly = false;
                    megaOnly.setBackground(UIManager.getColor("Button.background"));
                }
            }
        });
        classicOnly.setFocusPainted(false);
        add(classicOnly);

        megaOnly.setBounds((int) (WIDTH / 4 + (double) 25 / 1920 * WIDTH) + blackBorderXSize, (int) (HEIGHT / 2 + (double) 50 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 300 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(megaOnly);
        megaOnly.addActionListener(e -> {
            if (megaGobblegumOnly){
                megaGobblegumOnly = false;
                megaOnly.setBackground(UIManager.getColor("Button.background"));
            }
            else {
                megaGobblegumOnly = true;
                megaOnly.setBackground(buttonSelectedColor);

                if (classicGobblegumOnly){
                    classicGobblegumOnly = false;
                    classicOnly.setBackground(UIManager.getColor("Button.background"));
                }
            }
        });
        megaOnly.setFocusPainted(false);
        add(megaOnly);

        roundBased.setBounds((int) (WIDTH / 4 - (double) 325 / 1920 * WIDTH) + blackBorderXSize, (int) (HEIGHT / 2 + (double) 200 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 300 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(roundBased);
        roundBased.addActionListener(e -> {
            if (roundBasedOnly){
                roundBasedOnly = false;
                roundBased.setBackground(UIManager.getColor("Button.background"));
            }
            else {
                roundBasedOnly = true;
                roundBased.setBackground(buttonSelectedColor);
            }
        });
        roundBased.setFocusPainted(false);
        add(roundBased);

        timeBased.setBounds((int) (WIDTH / 4 + (double) 25 / 1920 * WIDTH) + blackBorderXSize, (int) (HEIGHT / 2 + (double) 200 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 300 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(timeBased);
        timeBased.addActionListener(e -> {
            if (timeBasedOnly){
            timeBasedOnly = false;
            timeBased.setBackground(UIManager.getColor("Button.background"));
            }
            else {
                timeBasedOnly = true;
                timeBased.setBackground(buttonSelectedColor);
            }
        });
        timeBased.setFocusPainted(false);
        add(timeBased);

        autoActivated.setBounds((int) (WIDTH / 4 - (double) 325 / 1920 * WIDTH) + blackBorderXSize, (int) (HEIGHT / 2 + (double) 300 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 300 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(autoActivated);
        autoActivated.addActionListener(e -> {
            if (autoActivatedOnly){
                autoActivatedOnly = false;
                autoActivated.setBackground(UIManager.getColor("Button.background"));
            }
            else {
                autoActivatedOnly = true;
                autoActivated.setBackground(buttonSelectedColor);
            }
        });
        autoActivated.setFocusPainted(false);
        add(autoActivated);

        playerActivated.setBounds((int) (WIDTH / 4 + (double) 25 / 1920 * WIDTH) + blackBorderXSize, (int) (HEIGHT / 2 + (double) 300 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 300 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(playerActivated);
        playerActivated.addActionListener(e -> {
            if (playerActivatedOnly){
                playerActivatedOnly = false;
                playerActivated.setBackground(UIManager.getColor("Button.background"));
            }
            else {
                playerActivatedOnly = true;
                playerActivated.setBackground(buttonSelectedColor);
            }
        });
        playerActivated.setFocusPainted(false);
        add(playerActivated);

        generatePackButton.setBounds((int) (WIDTH / 4 - (double) 120 / 1920 * WIDTH) + blackBorderXSize, HEIGHT / 8 + blackBorderYSize, (int) ((double) 240 / 1920 * WIDTH), (int) ((double) 80 / 1080 * HEIGHT));
        setButtonFont(generatePackButton);
        generatePackButton.addActionListener(e -> generateGobblegumPack());
        generatePackButton.setFocusPainted(false);
        add(generatePackButton);
    }

    private void drawClassic(){
        for (JButton button: buttonsMegaGobblegums){
            remove(button);
        }

        for (JButton button: buttonsClassicGobblegums){
            add(button);
        }
    }

    private void drawMega(){
        for (JButton button: buttonsClassicGobblegums){
            remove(button);
        }

        for (JButton button: buttonsMegaGobblegums){
            add(button);
        }
    }

    private void generateGobblegumPack(){
        for (JButton button : buttonsRandomGobblegums) remove(button);

        Random random = new Random();
        ArrayList<Image> randomGobblegums = new ArrayList<>();

        int amountOfGobblegums = 0;

        if (classicGobblegumOnly){
            for (Image gobblegum: imagesAllGobblegums){
                if (imagesClassicGobblegums.contains(gobblegum)){
                    if (!roundBasedOnly && !timeBasedOnly && !autoActivatedOnly && !playerActivatedOnly) amountOfGobblegums++;
                    else{
                        if (roundBasedOnly && imagesRoundBasedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                        else if (timeBasedOnly && imagesTimeBasedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                        else if (autoActivatedOnly && imagesAutoActivatedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                        else if (playerActivatedOnly && imagesPlayerActivatedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                    }
                }
            }
        }
        else if (megaGobblegumOnly){
            for (Image gobblegum: imagesAllGobblegums){
                if (imagesMegaGobblegums.contains(gobblegum)) {
                    if (!roundBasedOnly && !timeBasedOnly && !autoActivatedOnly && !playerActivatedOnly) amountOfGobblegums++;
                    else{
                        if (roundBasedOnly && imagesRoundBasedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                        else if (timeBasedOnly && imagesTimeBasedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                        else if (autoActivatedOnly && imagesAutoActivatedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                        else if (playerActivatedOnly && imagesPlayerActivatedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                    }
                }
            }
        }
        else {
            for (Image gobblegum: imagesAllGobblegums){
                if (!roundBasedOnly && !timeBasedOnly && !autoActivatedOnly && !playerActivatedOnly) amountOfGobblegums++;
                else {
                    if (roundBasedOnly && imagesRoundBasedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                    else if (timeBasedOnly && imagesTimeBasedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                    else if (autoActivatedOnly && imagesAutoActivatedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                    else if (playerActivatedOnly && imagesPlayerActivatedGobblegums.contains(gobblegum)) amountOfGobblegums++;
                }
            }
        }

        if (amountOfGobblegums > 5) amountOfGobblegums = 5;

        while (randomGobblegums.size() < amountOfGobblegums){
            Image randomGobblegum;

            randomGobblegum = imagesAllGobblegums.get(random.nextInt(imagesAllGobblegums.size()));

            if (!randomGobblegums.contains(randomGobblegum))
                if (!classicGobblegumOnly && !megaGobblegumOnly && !roundBasedOnly && !timeBasedOnly && !autoActivatedOnly && !playerActivatedOnly)
                    randomGobblegums.add(randomGobblegum);
                else{
                    if (classicGobblegumOnly && imagesClassicGobblegums.contains(randomGobblegum)){
                        if (!roundBasedOnly && !timeBasedOnly && !autoActivatedOnly && !playerActivatedOnly)
                            randomGobblegums.add(randomGobblegum);
                        else{
                            if (roundBasedOnly && imagesRoundBasedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                            else if (timeBasedOnly && imagesTimeBasedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                            else if (autoActivatedOnly && imagesAutoActivatedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                            else if (playerActivatedOnly && imagesPlayerActivatedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                        }
                    }
                    else if (megaGobblegumOnly && imagesMegaGobblegums.contains(randomGobblegum)){
                        if (!roundBasedOnly && !timeBasedOnly && !autoActivatedOnly && !playerActivatedOnly)
                            randomGobblegums.add(randomGobblegum);
                        else{
                            if (roundBasedOnly && imagesRoundBasedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                            else if (timeBasedOnly && imagesTimeBasedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                            else if (autoActivatedOnly && imagesAutoActivatedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                            else if (playerActivatedOnly && imagesPlayerActivatedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                        }
                    }
                    else if (!classicGobblegumOnly && !megaGobblegumOnly){
                        if (roundBasedOnly && imagesRoundBasedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                        else if (timeBasedOnly && imagesTimeBasedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                        else if (autoActivatedOnly && imagesAutoActivatedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                        else if (playerActivatedOnly && imagesPlayerActivatedGobblegums.contains(randomGobblegum)) randomGobblegums.add(randomGobblegum);
                    }
                }
        }

        for (int i = 0; i < randomGobblegums.size(); i++){
            JButton button = new JButton(new ImageIcon(randomGobblegums.get(i)));
            button.setBounds((int) (WIDTH * (2 * i)/20 + (double) (50 - (i + 1) * 15) / 1920 * WIDTH) + blackBorderXSize, (int) (HEIGHT * 8/20 - (double) 80 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 160 / 1920 * WIDTH), (int) ((double) 160 / 1080 * HEIGHT));
            button.setBackground(null);
            button.setBorder(null);
            button.setEnabled(false);
            button.setDisabledIcon(button.getIcon());
            add(button);
            buttonsRandomGobblegums.add(button);
        }
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(UIManager.getColor("Button.background"));
        g.fillRect((int) ((double) 20 / 1920 * WIDTH) + blackBorderXSize, (int) ((double) 337 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 898 / 1920 * WIDTH), (int) ((double) 190 / 1080 * HEIGHT));
        g.setColor(Color.BLACK);
        g.fillRect((int) ((double) 30 / 1920 * WIDTH) + blackBorderXSize, (int) ((double) 347 / 1080 * HEIGHT) + blackBorderYSize, (int) ((double) 878 / 1920 * WIDTH), (int) ((double) 170 / 1080 * HEIGHT));
    }
}