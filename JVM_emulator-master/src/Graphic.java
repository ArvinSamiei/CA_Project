import CUModule.ControlSignal;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Graphic extends Application {
    static Label mdr;
    static Label mar;
    static Label pc;
    static Label mbr;
    static Label sp;
    static Label lv;
    static Label cpp;
    static Label tos;
    static Label opc;
    static Label h;
    static Label b_bus_control = new Label();
    static Label c_bus_control = new Label();
    static Label memory_control = new Label();
    static Label ALU_shifter = new Label();
    static Label ALU__control = new Label();
    static Label isDone = new Label("wait");
    public static CPU cpu = new CPU();
    public static TextArea textArea = new TextArea("");

    @Override
    public void init() throws Exception {
        super.init();
    }

    static Button GoButton = new Button("Go");
    static Button stopButton = new Button("Stop");
    public Stage stage = new Stage();
    public Scene startMenu = new Scene(new Group(), 1280, 960, Color.BLUE);
    public Scene gameScene = new Scene(new Group(), 1280, 960, Color.GRAY);
    boolean endOfInsts = false;
    Thread t = new Thread();

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        StartScene startScene = new StartScene(new Group(), 1280, 960, Color.BLUE, stage);
        stage.setScene(startScene);
        stage.setTitle("Welcome Shahriar Javidi");
        stage.show();
        animationTimer.start();
        mdr = new Label("MDR : " + Graphic.cpu.getDataPath().getRegs().get(1).getValue());
        mar = new Label("MAR : " + Graphic.cpu.getDataPath().getRegs().get(0).getValue());
        pc = new Label("PC : " + Graphic.cpu.getDataPath().getRegs().get(2).getValue());
        mbr = new Label("MBR : " + Graphic.cpu.getDataPath().getRegs().get(3).getValue());
        sp = new Label("SP : " + Graphic.cpu.getDataPath().getRegs().get(4).getValue());
        lv = new Label("LV : " + Graphic.cpu.getDataPath().getRegs().get(5).getValue());
        cpp = new Label("CPP : " + Graphic.cpu.getDataPath().getRegs().get(6).getValue());
        tos = new Label("TOS : " + Graphic.cpu.getDataPath().getRegs().get(7).getValue());
        opc = new Label("OPC : " + Graphic.cpu.getDataPath().getRegs().get(8).getValue());
        h = new Label("H : " + Graphic.cpu.getDataPath().getRegs().get(9).getValue());


        GoButton.setOnMouseClicked(event -> {
            endOfInsts = false;
            String dastoor = textArea.getText();
            String[] dastoors = dastoor.split("\n");
            int i = 0;
            int counter = 0;
            for (String s : dastoors) {
                counter++;
                System.out.println(s);
                String[] bakhshha = s.split(" ");


                if (s.matches("BIPUSH .*")) {
                    cpu.getMemory().getData()[i] = 16;
                    cpu.getMemory().getData()[i + 1] = Integer.parseInt(bakhshha[1]);
                    i += 2;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.BIPUSH(cpu);
//
//                        }
//                    };
                    isWorking = true;
                }
                if (s.matches("IADD")) {
                    cpu.getMemory().getData()[i] = 96;
                    i++;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.IADD(cpu);
//                        }
//                    };
                    isWorking = true;
                }
                if (s.matches("IF_ICMPEQ.*")) {
                    cpu.getMemory().getData()[i] = 159;
                    cpu.getMemory().getData()[i + 1] = Integer.parseInt(bakhshha[1]) / 256;
                    cpu.getMemory().getData()[i + 2] = Integer.parseInt(bakhshha[1]) % 256;
                    i += 3;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.IF_ICMPEQ(cpu);
//                        }
//                    };
                    isWorking = true;
                }
                if (s.matches("IFEQ .*")) {
                    cpu.getMemory().getData()[i] = 153;
                    cpu.getMemory().getData()[i + 1] = Integer.parseInt(bakhshha[1]) / 256;
                    cpu.getMemory().getData()[i + 2] = Integer.parseInt(bakhshha[1]) % 256;
                    i += 3;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.IFEQ(cpu);
//                        }
//                    };
                    isWorking = true;
                }
                if (s.matches("IFLT .*")) {
                    cpu.getMemory().getData()[i] = 155;
                    cpu.getMemory().getData()[i + 1] = Integer.parseInt(bakhshha[1]) / 256;
                    cpu.getMemory().getData()[i + 2] = Integer.parseInt(bakhshha[1]) % 256;
                    i += 3;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.IFEQ(cpu);
//                        }
//                    };
                    isWorking = true;
                }
                if (s.matches("IINC .*")) {
                    cpu.getMemory().getData()[i] = 132;
                    cpu.getMemory().getData()[i + 1] = Integer.parseInt(bakhshha[1]);
                    cpu.getMemory().getData()[i + 2] = Integer.parseInt(bakhshha[2]);
                    i += 3;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.IINC_varnum(cpu);
//                        }
//                    };
                    isWorking = true;
                }
                if (s.matches("ILOAD .*")) {
                    cpu.getMemory().getData()[i] = 21;
                    cpu.getMemory().getData()[i + 1] = Integer.parseInt(bakhshha[1]);
                    i += 2;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.ILOAD_varnum(cpu);
//                        }
//                    };
                    isWorking = true;
                }
                if (s.matches("ISTORE .*")) {
                    cpu.getMemory().getData()[i] = 54;
                    cpu.getMemory().getData()[i + 1] = Integer.parseInt(bakhshha[1]);
                    i += 2;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.ISTORE_varnum(cpu);
//                        }
//                    };
                    isWorking = true;
                }
                if (s.matches("ISUB .*")) {
                    cpu.getMemory().getData()[i] = 100;
                    i += 1;
//                    t = new Thread() {
//
//
//                        @Override
//                        public void run() {
//                            CPU.ISUB(cpu);
//                        }
//                    };
                    isWorking = true;
                }

                if (s.matches("GOTO .*")) {
                    cpu.getMemory().getData()[i] = 167;
                    int a = Integer.parseInt(bakhshha[1]);
                    cpu.getMemory().getData()[i + 1] = a / 256;
                    cpu.getMemory().getData()[i + 2] = a % 256;
                    i += 3;
                    isWorking = true;
                }


//                t.start();
                isDone.setText("wait");
//                try {
//                    t.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (counter != dastoors.length) {
                    CPU.isDone = false;
                }

            }
            Thread t = new Thread() {
                @Override
                public void run() {
                    CPU.execute(cpu);
                }
            };
            t.start();
//            for (int i1 : cpu.getMemory().getData()) {
//                System.out.println(i1);
//            }

        });
        stopButton.setOnMouseClicked(event -> {
            cpu.reset();
            textArea.setText("");
            t.stop();
            CPU.isDone = false;
            isDone.setText("interrupted");
        });
        isDone.setFont(new Font("B Nazanin", 20));
        isDone.setTextFill(Color.GOLD);
        String style = "-fx-background-color: \n" +
                "        #a6b5c9,\n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 5,4,3,5;\n" +
                "    -fx-background-insets: 0,1,2,0;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-font-family: \"Nazanin\";\n" +
                "    -fx-font-size: 25px;\n" +
                "    -fx-padding: 10 20 10 20;" +
                "-fx-font-weight: bold;";
        isDone.setStyle(style);
        mdr.setStyle(style);
        mar.setStyle(style);
        pc.setStyle(style);
        mbr.setStyle(style);
        sp.setStyle(style);
        lv.setStyle(style);
        cpp.setStyle(style);
        tos.setStyle(style);
        opc.setStyle(style);
        h.setStyle(style);
        c_bus_control.setStyle(style);
        b_bus_control.setStyle(style);
        memory_control.setStyle(style);
        ALU__control.setStyle(style);
        ALU_shifter.setStyle(style);
    }

    boolean mainSceneMade = false;
    boolean isWorking = false;
    boolean bool = false;

    AnimationTimer animationTimer = new AnimationTimer() {

        @Override
        public void handle(long now) {
            if (stage.getScene() instanceof MainScene) {
                MainScene mainScene = (MainScene) stage.getScene();
                Group root = (Group) mainScene.getRoot();
                if (CPU.isDone == true) {
                    isDone.setText("Done");
                    String s1 = "";
                    int counter = 0;
                    for (int i : cpu.getMemory().getData()) {
                        s1 = s1 + " home " + counter + ":" + i + " | ";
                        counter++;
                    }
                    System.out.println(s1);
                    TextArea memLabel = new TextArea(s1);
//                    memLabel.setMaxWidth(500);
                    memLabel.relocate(0, 700);
                    memLabel.setMaxWidth(500);
                    memLabel.setMaxHeight(100);
//                    memLabel.setStyle("-fx-background-color: \n" +
//                            "        #a6b5c9,\n" +
//                            "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
//                            "        linear-gradient(#020b02, #3a3a3a),\n" +
//                            "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
//                            "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
//                            "    -fx-background-radius: 5,4,3,5;\n" +
//                            "    -fx-background-insets: 0,1,2,0;\n" +
//                            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
//                            "    -fx-font-family: \"Nazanin\";\n" +
//                            "    -fx-font-size: 25px;\n" +
//                            "    -fx-padding: 10 20 10 20;" +
//                            "-fx-font-weight: bold;");
                    root.getChildren().add(memLabel);
                    CPU.isDone = false;
                }

                if (bool == false) {
                    root.getChildren().add(textArea);
                    root.getChildren().addAll(GoButton, stopButton, isDone);
                    isDone.relocate(500, 0);

                    GoButton.relocate(310, 0);
                    stopButton.relocate(310, 30);
                    textArea.setMaxWidth(300);
                    textArea.setMaxHeight(100);
                    bool = true;
                }
                if (mainSceneMade == false) {
                    mar.relocate(100, 100);
                    Font nazanin = new Font("B Nazanin", 25);
                    Font nazanin2 = new Font("B Nazanin", 38);
                    mar.setFont(nazanin2);
                    mar.setTextFill(Color.DARKBLUE);
                    root.getChildren().add(mar);
                    mdr.relocate(300, 100);
                    mdr.setFont(nazanin2);
                    mdr.setTextFill(Color.DARKGREEN);
                    root.getChildren().add(mdr);
                    pc.relocate(500, 100);
                    pc.setFont(nazanin2);
                    pc.setTextFill(Color.DARKGOLDENROD);
                    root.getChildren().add(pc);

                    mbr.relocate(700, 100);
                    mbr.setFont(nazanin2);
                    mbr.setTextFill(Color.RED);
                    root.getChildren().add(mbr);

                    sp.relocate(900, 100);
                    sp.setFont(nazanin2);
                    sp.setTextFill(Color.YELLOWGREEN);
                    root.getChildren().add(sp);

                    lv.relocate(1100, 100);
                    lv.setFont(nazanin2);
                    lv.setTextFill(Color.YELLOW);
                    root.getChildren().add(lv);

                    cpp.relocate(100, 300);
                    cpp.setFont(nazanin2);
                    cpp.setTextFill(Color.ORANGE);
                    root.getChildren().add(cpp);

                    tos.relocate(300, 300);
                    tos.setFont(nazanin2);
                    tos.setTextFill(Color.YELLOWGREEN);
                    root.getChildren().add(tos);

                    opc.relocate(500, 300);
                    opc.setFont(nazanin2);
                    opc.setTextFill(Color.BEIGE);
                    root.getChildren().add(opc);

                    h.relocate(700, 300);
                    h.setFont(nazanin2);
                    h.setTextFill(Color.PURPLE);
                    root.getChildren().add(h);

                    HBox hBox = new HBox();
                    hBox.relocate(10, 600);
                    hBox.getChildren().addAll(b_bus_control, c_bus_control, memory_control, ALU__control, ALU_shifter);
                    root.getChildren().add(hBox);

                    b_bus_control.setFont(nazanin);
                    b_bus_control.setTextFill(Color.GREEN);
                    c_bus_control.setFont(nazanin);
                    c_bus_control.setTextFill(Color.RED);
                    memory_control.setFont(nazanin);
                    memory_control.setTextFill(Color.DARKBLUE);
                    ALU__control.setFont(nazanin);
                    ALU__control.setTextFill(Color.GOLD);
                    ALU_shifter.setFont(nazanin);
                    ALU_shifter.setTextFill(Color.BROWN);


                    mainSceneMade = true;
                }


                mar.setText("MAR : " + Graphic.cpu.getDataPath().getRegs().get(0).getValue());
                mdr.setText("MDR : " + Graphic.cpu.getDataPath().getRegs().get(1).getValue());
                pc.setText("PC : " + Graphic.cpu.getDataPath().getRegs().get(2).getValue());
                mbr.setText("MBR : " + Graphic.cpu.getDataPath().getRegs().get(3).getValue());
                sp.setText("SP : " + Graphic.cpu.getDataPath().getRegs().get(5).getValue());
                lv.setText("LV : " + Graphic.cpu.getDataPath().getRegs().get(6).getValue());
                cpp.setText("CPP : " + Graphic.cpu.getDataPath().getRegs().get(7).getValue());
                tos.setText("TOS : " + Graphic.cpu.getDataPath().getRegs().get(8).getValue());
                opc.setText("OPC : " + Graphic.cpu.getDataPath().getRegs().get(9).getValue());
                h.setText("H : " + Graphic.cpu.getDataPath().getRegs().get(10).getValue());
                ControlSignal controlSignal = cpu.getCu().getControlSignal();
                b_bus_control.setText("b bus Control : " + cpu.getCu().getControlSignal().getB_bus_control()[8] + cpu.getCu().getControlSignal().getB_bus_control()[7] + cpu.getCu().getControlSignal().getB_bus_control()[6] + cpu.getCu().getControlSignal().getB_bus_control()[5] + cpu.getCu().getControlSignal().getB_bus_control()[4] + cpu.getCu().getControlSignal().getB_bus_control()[3] + cpu.getCu().getControlSignal().getB_bus_control()[2] + cpu.getCu().getControlSignal().getB_bus_control()[1] + cpu.getCu().getControlSignal().getB_bus_control()[0]);
                c_bus_control.setText("c bus control : " + cpu.getCu().getControlSignal().getC_bus()[8] + cpu.getCu().getControlSignal().getC_bus()[7] + cpu.getCu().getControlSignal().getC_bus()[6] + cpu.getCu().getControlSignal().getC_bus()[5] + cpu.getCu().getControlSignal().getC_bus()[4] + cpu.getCu().getControlSignal().getC_bus()[3] + cpu.getCu().getControlSignal().getC_bus()[2] + cpu.getCu().getControlSignal().getC_bus()[1] + cpu.getCu().getControlSignal().getC_bus()[0]);
                int[] Memory_Control_Signals = controlSignal.getMemory_control();
                int[] ALU_SHIFT_CONTROLS = controlSignal.getALU_shifter();
                int[] ALU_CONTROL = controlSignal.getALU_control();
                memory_control.setText("memory control : " + controlSignal.getMemory_control()[4] + controlSignal.getMemory_control()[3] + Memory_Control_Signals[2] + Memory_Control_Signals[1] + Memory_Control_Signals[0]);
                ALU_shifter.setText("alu shift control : " + ALU_SHIFT_CONTROLS[1] + ALU_SHIFT_CONTROLS[0]);
                ALU__control.setText("alu control : " + ALU_CONTROL[5] + ALU_CONTROL[4] + ALU_CONTROL[3] + ALU_CONTROL[2] + ALU_CONTROL[1] + ALU_CONTROL[1]);
            }
        }
    };

    public static void main(String[] args) {
        cpu.reset();
        cpu.getMemory().initial();
//        CPU cpu = new CPU();
        launch(args);

//        cpu.reset();
//        cpu.getMemory().initial();
//        ControllerClass controller = new ControllerClass();
//        example(cpu);
    }
}