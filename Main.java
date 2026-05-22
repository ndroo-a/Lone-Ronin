package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	//Items
	static String [] d = new String [5]; //dummy
	static Integer [] D = new Integer [5]; //Damage Output
	static String [] I = new String [6]; //Inventory Items
	static Integer [] i = new Integer [6]; //inventory count
	private static Pane gamePane;
	private static Text txtTop;
	private static Text txtBottom;
	private static Text txtR1;
	private static Text txtR2;
	private static Text txtL;
	private static Text txtH;
	private static Text txtD;
	private static Button btnStart;
	private static Button btnQuit;
	private static Button btnDagger;
	private static Button btnKatana;
	private static Button btnBow;
	private static ListView<String> LstR;
	private static ListView<String> LstL;
	private static Label lblbox;
	private static Scene scene1;
	private static int flag = 1;
	private static int Sflag = 0;
	private static int Dflag = 0;
	private static int Oflag = 0;
	private static int dmg = 0;
	private static int dag = 1;
	private static int bow = 1;
	private static int kat = 2;
	private static int UHealth = 10;
	private static int NHealth = 8;
@Override
public void start(Stage primaryStage) {
//Inventory Items
	//Inventory Count
	i[1] = 0;
	i[2] = 0;
	i[3] = 0;
	i[4] = 0;
	i[5] = 0;
	//Inventory Items
	I[1] = "";
	I[2] = "";
	I[3] = "Katana";
	I[4] = "Kabuto";
	I[5] = "Bow";
//Damage Output Value
	D[1] = 0;
//Icon
	primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("ninja.png")));
//Pane
	gamePane = new Pane();
	gamePane.setStyle("-fx-background-color: darkred");
//Text
	txtTop = new Text(295,170,"Lone Ronin");
	txtTop.setFont(Font.font("Serif",40));
	txtTop.setFill(Color.WHITE);
	gamePane.getChildren().add(txtTop);
	Text txtCredit = new Text(285,200,"An Andreu Austraw Original Story");
	txtCredit.setFont(Font.font("Serif",15));
	txtCredit.setFill(Color.WHITE);
	gamePane.getChildren().add(txtCredit);
//Label
	lblbox = new Label();
	lblbox.setWrapText(true);
	lblbox.setFont(Font.font("Serif",18));
	lblbox.setMaxWidth(400);
	lblbox.setText(d[1]);
	lblbox.relocate(200,85);
	lblbox.setStyle("-fx-background-color: white");
	gamePane.getChildren().add(lblbox);
	lblbox.setVisible(false);
//Buttons
	btnQuit = new Button("Quit");
	btnQuit.setOnAction(e -> exitProgram());
	gamePane.getChildren().add(btnQuit);
	btnQuit.relocate(450,225);
	Button btnStory = new Button("Story");
	btnStory.setOnAction(e -> {
		btnStart.setVisible(false);
		btnStory.setVisible(false);
		btnQuit.setVisible(false);
		txtTop.relocate(300,25);
		txtCredit.setVisible(false);
		story();
		});
	btnStory.relocate(375,225);
	gamePane.getChildren().add(btnStory);
	btnStart = new Button("Start");
	btnStart.setOnAction(e -> {
		btnStart.setVisible(false);
		btnStory.setVisible(false);
		btnQuit.relocate(50, 375);
		//Text
		txtTop.relocate(300,25);
		lblbox.setVisible(true);
		txtCredit.setVisible(false);
		bedRoom();
	});
	btnStart.relocate(300,225);
	gamePane.getChildren().add(btnStart);
//Scene
	scene1 = new Scene(gamePane, 800, 425);
	primaryStage.setOnCloseRequest(e -> exitProgram());
	primaryStage.setTitle("Lone Ronin");
	primaryStage.setScene(scene1);
	primaryStage.show();
	primaryStage.setResizable(false);
}

public static void main(String[] args) {
	launch(args);
}
//Methods
		private static void exitProgram() {
			System.out.println("Finished");
			System.exit(0);
		}//end of exitProgram
		private static void story() {
			d[1] = "	You are a wealthy and accomplished samurai in feudal Japan, when one night you awaken from your bed next to your wife to a strange crashing noise in the eastern wing of your residence. Cautiously, you approach the door of your bedroom to investigate the cause of the sound, but as you begin to exit the bedroom, you feel a sharp pain to the back of your head, and everything goes black.";
			d[2] = "	You awaken to daylight and now clearly able to see your family’s home for generations has been ravaged and to your dismay, as you call out for your wife and children is answered only with silence. With an aching crown, and vengeful rage, you must set out to find your family and make those who have taken them from you pay.";
		//Labels
			lblbox.setVisible(true);
			lblbox.setText(d[1]);
		//Buttons
			Button btnContinue = new Button("Continue");
			btnContinue.relocate(300,350);
			btnContinue.setOnAction(e ->{		
			if (flag >= 1) 
			{
				flag = flag + 1;
				lblbox.setText(d[flag]);
				if (flag > 1)
				{
					flag = 1;
					btnContinue.setDisable(true);
				}//end of inner if
			}//end of outer if
			});//end of btnContinue
			gamePane.getChildren().add(btnContinue);
			btnStart = new Button("Start");
			btnStart.relocate(375,350);
			btnStart.setOnAction(e ->{
				btnContinue.setVisible(false);
				btnStart.setVisible(false);
				btnQuit.relocate(50, 375);
				//Text
				txtTop.relocate(300,25);
				bedRoom();
				});
			gamePane.getChildren().add(btnStart);
			btnQuit = new Button("Quit");
			btnQuit.setOnAction(e -> exitProgram());
			btnQuit.relocate(425,350);
			gamePane.getChildren().add(btnQuit);
		}//end of story
		private static void bedRoom() {
		//Label
			d[1] = "Looking ahead of you there is the sole exit of your home to the South, the kitchen to the West, and your personal armory to the East.";
			lblbox.setText(d[1]);
		//Text
			txtR1 = new Text(650,80,"Direction");
			txtR1.setFont(Font.font(20));
			txtR1.setFill(Color.WHITE);
			gamePane.getChildren().add(txtR1);
			txtL = new Text(70,80,"Inventory");
			txtL.setFont(Font.font(20));
			txtL.setFill(Color.WHITE);
			gamePane.getChildren().add(txtL);
		//BoxL (Inventory)
			LstL = new ListView<>();
			LstL.getItems().addAll(I[1], I[2]);
			gamePane.getChildren().add(LstL);
			LstL.setPrefSize(100,100);
			LstL.relocate(50,100);
		//BoxR (Directions)
			LstR = new ListView<>();
			LstR.getItems().addAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().remove("Go North");
			LstR.setPrefSize(100,100);
			LstR.relocate(650,100);
		//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go South")
				{
					roadI();
				}//end of if
				if(choice == "Go East")
				{
					armory();
				}//end of if
				if(choice == "Go West")
				{
					kitchen();
				}//end of if
			});
			gamePane.getChildren().add(LstR);
		}//end of bedRoom
		private static void kitchen() {
		//Label
			d[1] = "You enter your kitchen to find cabinets doors hanging from hinges, broken dishes on the floor, and silverware strewn across the floor.";
			d[2] = " Through the mess you notice a small shining metal object, getting closer you determine it appears to be an ancient skeleton key you have never seen before. Unsure of its use, you pick up the key and put it in your kate-bukuro (provisional bag).";
			if (i[1] == 0) 
			{
				lblbox.setText(d[1] + d[2]);
				I[1] = "Key";
				System.out.println(i[1]);
			}//end of if
			else			
			{
				lblbox.setText(d[1]);
			}//end of if		
		//Box R (Directions)
			LstR.getItems().removeAll("Go South", "Go West");
		//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go East")
				{
					bedRoom();
					if (i[1] == 0)
					{
						i[1] = 1;
					}//end of inner if
					System.out.println(i[1]);
				}//end of if
			});
		}//end of kitchen
		private static void armory() {
			//Label
				d[1] = "You enter your armory finding decorative art pieces missing or shredded, books thrown from shelves, drawers pulled out of dressers, and unfortunately, the lock on the weapons and armor cabinets broken, revealing both your full set of samurai armor and katana missing.";
				d[2] = " Luckily whoever did this overlooked the humble Tanto (small dagger) and left it behind. Acknowledging it isn't much, but it will do for now, you sheath the dagger on your belt.";
				if (i[2] == 0) 
				{
					lblbox.setText(d[1] + d[2]);
					I[2] = "Dagger";
				}//end of if
				else			
				{
					lblbox.setText(d[1]);
				}//end of if		
			//Box R (Directions)
				LstR.getItems().removeAll("Go South", "Go East");
			//Mouse Event
				LstR.setOnMouseClicked(e -> {
					Object choice = LstR.getSelectionModel().getSelectedItem();
					if(choice == "Go West")
					{
						bedRoom();
						if (i[2] == 0)
						{
							i[2] = 1;
						}//end of inner if
					}//end of if
				});
		}//end of armory
		private static void roadI() {
			//Label
			d[1] = "A road ahead of you (to the South) leads into the local village, behind you (to the North) is the entry way to your pillaged home.";
			lblbox.setText(d[1]);
			//Box R (Directions)
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go North", "Go South");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go North")
				{
					bedRoom();
				}//end of if
				if(choice == "Go South")
				{
					village();
				}//end of if
			});
		}//end of roadI()
		private static void village() {
			//Label
			d[1] = "You walk through the local village, having provided protection to the local population and raising your family in the area for years, you are taken a back by the state of it. Buildings lining the streets have been stripped clean of their valuables, doors and canvas ripped from their exteriors, some even burning still from fires set some time ago.";
			d[2] = "But, through the smoke and fires you are able to hear what sounds like voices coming from the South. To the East, you notice a cinder coated house that still appears sound, and to your West the road continues on, and also remains to the North where you came from.";
			lblbox.setText(d[1]);
			Button btnContinue = new Button("Continue");
			btnContinue.setVisible(true);
			btnContinue.relocate(300,350);
			btnContinue.setOnAction(e ->{		
			if (flag >= 1) 
			{
				flag = flag + 1;
				lblbox.setText(d[flag]);
				if (flag > 1)
				{
					flag = 1;
					btnContinue.setDisable(true);
				}//end of inner if
			}//end of outer if
			});//end of btnContinue
			gamePane.getChildren().add(btnContinue);
			//Box R (Directions)
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go North", "Go East", "Go West", "Go South");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go North")
				{
					btnContinue.setVisible(false);
					roadI();
				}//end of if
				if(choice == "Go East")
				{
					btnContinue.setVisible(false);
					house();
				}//end of if
				if(choice == "Go West")
				{
					btnContinue.setVisible(false);
					roadII();
				}//end of if
				if(choice == "Go South")
				{
					btnContinue.setVisible(false);
					forge();
				}//end of if
			});
		}//end of village()
		private static void forge() {
			//Label
			d[1] = "Through the smoke you find the source of the noise you heard to be coming from the local forge. Following the voices, you enter the building to find the local blacksmith and his family hiding in a backroom.";
			d[2] = "The blacksmith's face is full of tension clearly in fear of someone or something, in an effort to calm him you assure him that the village is empty and no threat remains. Once he has quieted, you inquire about the state of the town to which he replies he sadly did not see much of anything, someone or something swept through the town so inhumanly fast he could not even make out what this force even was."; 
			d[3] = "All he could remember is the screams of children and women as the wave of destruction washed over them. Noticing you are an extremely skilled samurai, he urges you to go after this force it must be stopped lest it attacks other villages like it had here. To aid you on your journey he gifts you with katana he had just finished before the darkness came.";
			lblbox.setText(d[1]);
			//Button
			Button btnContinue = new Button("Continue");
			btnContinue.setVisible(true);
			btnContinue.relocate(300,350);
			btnContinue.setOnAction(e ->{		
			if (flag >= 1) 
			{
				flag = flag + 1;
				lblbox.setText(d[flag]);
				if (flag > 2)
				{
					flag = 1;
					btnContinue.setDisable(true);
				}//end of inner inner if
			}//end of inner if
			});//end of btnContinue
			gamePane.getChildren().add(btnContinue);
			if(i[3] == 0)
			{
			btnContinue.setVisible(true);
			}//end of outer if
			else
			{
				btnContinue.setVisible(false);
			}//end of else
			//Box R (Directions)		
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().add("Go North");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go North")
				{
					if (i[3] == 0)
					{
						LstL.getItems().add(I[3]);
						i[3] = 1;
					}//end of inner if
					btnContinue.setVisible(false);
					village();
				}//end of if
			});
		}//end of forge()
		private static void house() {
			//Label
			d[1] = "Observing the small house you notice it is in a similar state to your own, with seemingly little to offer you for your journey. ";
			d[2] = "On the way out your foot catches on something as you go to leave, looking down you spot a small, easily overlooked chest with an eerily familiar pattern. You attempt to open it with your key and find it works revealing a kabuto! (+2 Health Buff)";
			lblbox.setText(d[1]);
			if (i[1] == 1)//key
			{
			if (i[4] == 0)//kabuto
			{
				lblbox.setText(d[1] + d[2]);
			}//end of inner if
			else			
			{
				lblbox.setText(d[1]);
			}//end of inner else
			}//end of if
			//Box R (Directions)		
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().add("Go West");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go West")
				{
					System.out.println("Go West");
					if (i[4] == 0)
					{
						i[4] = 1;
						LstL.getItems().add(I[4]);
						UHealth = UHealth + 2;
					}//end of inner if
					village();
				}//end of if
			});
		}//end of house()
		private static void roadII() {
			//Label
			d[1] = "Now on the road, behind you (to the East) it leads back into the small village, and ahead of you (to the West) the muddied road leads you closer to finding your family.";
			lblbox.setText(d[1]);
			//Box R (Directions)	
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go East", "Go West");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go East")
				{
					village();
				}//end of if
				if(choice == "Go West")
				{
					woman();
				}//end of if
			});
		}//end of roadII()
		private static void woman() {
			//Label
			d[1] = "A dishelved looking woman sits on the side of the road next to the bodies of a few bandits clad in dark cloth, knives by there side. As you go to approach her and see if she needs help, she contorts her body into that of a giant snake! Keeping her human head, she coils and launches at you bearing her poisonous fangs!";
			d[2] = "The body of the snake woman lies on the side of the muddied road, felled by your sword.";
			lblbox.setText(d[1]);
			if (Sflag == 1)
			{
				lblbox.setText(d[2]);
				btnDagger.setVisible(false);
				txtH.setVisible(false);
				txtD.setVisible(false);
			}//end of if
			//Text
			txtH = new Text(650,325,"Health: " + UHealth);
			txtH.setFont(Font.font(20));
			txtH.setFill(Color.WHITE);
			gamePane.getChildren().add(txtH);
			txtD = new Text(650,375,"Damage: " + dmg);
			txtD.setFont(Font.font(20));
			txtD.setFill(Color.WHITE);
			gamePane.getChildren().add(txtD);
			//End Turn
			Button endturn = new Button("End Turn");
			endturn.setVisible(false);
			endturn.setOnAction(e -> {
				LstR.setDisable(true);
				btnDagger.setDisable(false);
				endturn.setDisable(true);
				dmg = (int) (Math.random()* 3 + 1);
				lblbox.setText("The Snake Woman takes her attack! "
						+ "Base Damage: " + dmg);
				UHealth = UHealth - dmg;
				D[2] = UHealth;
				txtH.setText("Health: " + D[2]);
				if (D[2] <= 0)
				{
					lblbox.setText("The Snake Woman has Defeated You!");
					txtTop.setText("The End");
					btnDagger.setVisible(false);
					endturn.setVisible(false);
				}//end of if
				});
			endturn.relocate(415,300);
			gamePane.getChildren().add(endturn);
			//Dagger
			btnDagger = new Button("Use Dagger");
			btnDagger.setVisible(false);
			btnDagger.setOnAction(e -> {
				LstR.setDisable(true);
				btnDagger.setDisable(true);
				endturn.setDisable(false);
				dmg = (int) (Math.random()* 3 + 1);
				lblbox.setText("Base Damage: " + dmg);
				dmg = dmg + dag;
				lblbox.setText("Damage (With Dagger): " + dmg);
				txtD.setText("Damage: " + dmg);
				NHealth = NHealth - dmg;
				D[1] = NHealth;
				if (D[1] <= 0)
				{
					lblbox.setText("You have defeated the Snake Woman!");
					btnDagger.setVisible(false);
					endturn.setVisible(false);
					txtH.setVisible(false);
					txtD.setVisible(false);
					LstR.setDisable(false);
				}//end of if
				System.out.println(dmg);
				});
			btnDagger.relocate(315,300);
			if (i[2] == 1)
			{
				gamePane.getChildren().add(btnDagger);
			}//end of if
			//Attack
			Button attack = new Button("Attack!");
			attack.setOnAction(e -> {
				LstR.setDisable(true);
				attack.setVisible(false);
				btnDagger.setVisible(true);
				endturn.setVisible(true);
				});
			attack.relocate(375,300);
			gamePane.getChildren().add(attack);
			//Box R (Directions)	
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go East", "Go South");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go East")
				{
					roadII();
					Sflag = 1;
					attack.setVisible(false);
				}//end of if
				if(choice == "Go South")
				{
					pathI();
					Sflag = 1;
					attack.setVisible(false);
				}//end of if
			});
		}//end of woman()
		private static void pathI() {
			//Label
			d[1] = "Now on the path, you see to the South there appears to be numerous sets of footprints as well as two sets of lines in the mud implying a pair of people had been dragged towards the beach. To your North lies the road where you had bested the strange snake witch.";
			lblbox.setText(d[1]);
			//Box R (Directions)	
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go North", "Go South");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go North")
				{
					woman();
				}//end of if
				if(choice == "Go South")
				{
					beach();
				}//end of if
			});
		}//end of pathI()
		private static void beach() {
			//Label
			d[1] = "You follow the tracks and are lead to the beach of the local village, surrounded by rough waters, jagged rocks, and the worn wreckage of old fishing and trading ships, you feel uneasy as you follow the tracks until they have been washed away and you are left to explore the fragmented parts leftover from a shipwreck (to the West), or venture further into the fog hoping to find a way out (to the South).";
			lblbox.setText(d[1]);
			//Box R (Directions)	
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go West", "Go South");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go West")
				{
					shipwreck();
				}//end of if
				if(choice == "Go South")
				{
					fog();
				}//end of if
			});
		}//end of beach()
		private static void shipwreck() {
			//Label
			d[1] = " Walking through the splintered and rotted boards that once made up an enourmous sailing vessel you notice most of the contents of the ship have been washed away by the tides. ";
			d[2] = "Looking a bit further you see a pile of boards that look unnaturally organized, after moving them you eye another chest lying underneath that the skeleton key matches, you open it to find a bow!";
			lblbox.setText(d[1]);
			if (i[1] == 1)//key
			{
			if (i[5] == 0)//bow
			{
				lblbox.setText(d[1] + d[2]);
				System.out.println(i[5]);
			}//end of inner if
			else			
			{
				lblbox.setText(d[1]);
			}//end of inner else
			}//end of if
			//Box R (Directions)		
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().add("Go East");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go East")
				{
					System.out.println("Go East");
					if (i[5] == 0)
					{
						i[5] = 1;
						LstL.getItems().add(I[5]);
					}//end of inner if
					beach();
				}//end of if
			});
		}//end of shipwreck()
		private static void fog() {
			
			UHealth = 10;
			if (i[4] == 1)
			{
				UHealth = 12;
			}//end of if
			else
			{
				UHealth = 10;
			}//end of else
			NHealth = 10;
			//Label
			d[1] = "In the fog, you make out the silhouette of a very round man a few meters in front of you. You ask him to identify himself, receiving no response you move your hand to the handle of your blade. As the man steps forward you see he is not a man at all, but a turtle shell bearing, humanoid water demon!";
			d[2] = "The fog remains, making it hard to see, but with the tide now risen the water demon's body has been washed out to sea.";
			lblbox.setText(d[1]);
			if (Dflag == 1)
			{
				lblbox.setText(d[2]);
				btnKatana.setVisible(false);
				txtH.setVisible(false);
				txtD.setVisible(false);
			}//end of if
			//Text
			txtH.setVisible(true);
			txtH.setText("Health: " + UHealth);
			txtD.setVisible(true);
			txtD.setText("Damage: " + dmg);
			//End Turn
			Button endturn = new Button("End Turn");
			endturn.setVisible(false);
			endturn.setOnAction(e -> {
				LstR.setDisable(true);
				btnKatana.setDisable(false);
				endturn.setDisable(true);
				dmg = (int) (Math.random()* 4 + 1);
				lblbox.setText("The Water Demon takes his attack! "
						+ "Base Damage: " + dmg);
				UHealth = UHealth - dmg;
				D[2] = UHealth;
				txtH.setText("Health: " + D[2]);
				if (D[2] <= 0)
				{
					lblbox.setText("The Water Demon has Defeated You!");
					txtTop.setText("The End");
					btnKatana.setVisible(false);
					endturn.setVisible(false);
				}//end of if
				});
			endturn.relocate(415,300);
			gamePane.getChildren().add(endturn);
			//Katana
			btnKatana = new Button("Use Katana");
			btnKatana.setVisible(false);
			btnKatana.setOnAction(e -> {
				LstR.setDisable(true);
				btnKatana.setDisable(true);
				endturn.setDisable(false);
				dmg = (int) (Math.random()* 3 + 1);
				lblbox.setText("Base Damage: " + dmg);
				dmg = dmg + kat;
				lblbox.setText("Damage (With Katana): " + dmg);
				txtD.setText("Damage: " + dmg);
				NHealth = NHealth - dmg;
				D[1] = NHealth;
				if (D[1] <= 0)
				{
					lblbox.setText("You have defeated the Water Demon!");
					btnKatana.setVisible(false);
					endturn.setVisible(false);
					LstR.setDisable(false);
					//set a counter so that the combat does not start over if they return
					//figure out how to do directions
				}//end of if
				System.out.println(dmg);
				});
			btnKatana.relocate(315,300);
			if (i[3] == 1)
			{
				gamePane.getChildren().add(btnKatana);
			}//end of if
			//Attack
			Button attack = new Button("Attack!");
			attack.setOnAction(e -> {
				LstR.setDisable(true);
				attack.setVisible(false);
				btnKatana.setVisible(true);
				endturn.setVisible(true);
				});
			attack.relocate(375,300);
			gamePane.getChildren().add(attack);
			//Box R (Directions)	
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go North", "Go East");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go North")
				{
					beach();
					Dflag = 1;
					attack.setVisible(false);
				}//end of if
				if(choice == "Go East")
				{
					mountainPass();
					Dflag = 1;
					attack.setVisible(false);
				}//end of if
			});
		}//end of fog()
		private static void mountainPass() {
			//Label
			d[1] = "Walking out of the fog you are led through a pass between two steep saw-toothed faces, as you walk on you see to your East the mouth of pitch black cave comes into view, leading up to that mouth are a trail of familiar footprints. To your West lies the beginning of the pass leading back to where you had bested the water demon.";
			lblbox.setText(d[1]);
			//Box R (Directions)	
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go East", "Go West");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go East")
				{
					cave();
				}//end of if
				if(choice == "Go West")
				{
					fog();
				}//end of if
			});
		}//end of mountainPass()
		private static void cave() {
			UHealth = 10;
			if (i[4] == 1)
			{
				UHealth = 12;
			}//end of if
			else
			{
				UHealth = 10;
			}//end of else
			NHealth = 15;
			//Label
			d[1] = "As you enter the light vacuum that is the cave, a foul stench overwhelms your nose and you hear a low growling sound echoing through the rock walls. You recognize this signature sound in scent to be from one mythical creature that you have had run ins with in your work, but never been able to fell: the shuten doji. ";
			d[2] = "This mythical beast dwells far from civilization in caves on mountains such as this one. He is often described as an evil Ogre King he has been known to kidnap women and eat them. To save your family you must defeat the monster once and for all, but to face him head on would be suicide, and because of that you must use the bow.";
			d[3] = "You have defeated the Ogre King and Saved your Family! You see the mountain pass you came from to your West, and a light source, possibly a way out to your East.";
			lblbox.setText(d[1]);
			if (Oflag == 1)
			{
				lblbox.setText(d[3]);
				btnBow.setVisible(false);
				txtH.setVisible(false);
				txtD.setVisible(false);
			}//end of if
			//Text
			txtH.setVisible(true);
			txtH.setText("Health: " + UHealth);
			txtD.setVisible(true);
			txtD.setText("Damage: " + dmg);
			//End Turn
			Button endturn = new Button("End Turn");
			endturn.setVisible(false);
			endturn.setOnAction(e -> {
				LstR.setDisable(true);
				btnBow.setDisable(false);
				endturn.setDisable(true);
				dmg = (int) (Math.random()* 4 + 1);
				lblbox.setText("The Ogre King takes his attack! "
						+ "Base Damage: " + dmg);
				UHealth = UHealth - dmg;
				D[2] = UHealth;
				txtH.setText("Health: " + D[2]);
				if (D[2] <= 0)
				{
					lblbox.setText("The Ogre King has Defeated You!");
					txtTop.setText("The End");
					btnBow.setVisible(false);
					endturn.setVisible(false);
				}//end of if
				});
			endturn.relocate(415,300);
			gamePane.getChildren().add(endturn);
			//Dagger
			btnBow = new Button("Use Bow");
			btnBow.setVisible(false);
			btnBow.setOnAction(e -> {
				LstR.setDisable(true);
				btnBow.setDisable(true);
				endturn.setDisable(false);
				dmg = (int) (Math.random()* 3 + 1);
				lblbox.setText("Base Damage: " + dmg);
				dmg = dmg + bow;
				lblbox.setText("Damage (With Bow): " + dmg);
				txtD.setText("Damage: " + dmg);
				NHealth = NHealth - dmg;
				D[1] = NHealth;
				if (D[1] <= 0)
				{
					lblbox.setText("You have defeated the Ogre King and Saved your Family! You manage to see your wife and your son tied up to a stalagmite just to your East in the cave, and to your West, the moutain pass you came from.");
					btnBow.setVisible(false);
					endturn.setVisible(false);
					LstR.setDisable(false);
					//set a counter so that the combat does not start over if they return
					//figure out how to do directions
				}//end of if
				System.out.println(dmg);
				});
			btnBow.relocate(315,300);
			if (i[5] == 1)
			{
				gamePane.getChildren().add(btnBow);
			}//end of if
			//Attack
			Button attack = new Button("Attack!");
			attack.setOnAction(e -> {
				LstR.setDisable(true);
				attack.setVisible(false);
				btnBow.setVisible(true);
				endturn.setVisible(true);
				lblbox.setText(d[2]);
				});
			attack.relocate(375,300);
			gamePane.getChildren().add(attack);
			//Box R (Directions)	
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
			LstR.getItems().addAll("Go East", "Go West");
			//Mouse Event
			LstR.setOnMouseClicked(e -> {
				Object choice = LstR.getSelectionModel().getSelectedItem();
				if(choice == "Go West")
				{
					mountainPass();
					Oflag = 1;
					attack.setVisible(false);
				}//end of if
				if(choice == "Go East")
				{
					exit();
					Oflag = 1;
					attack.setVisible(false);
				}//end of if
			});
		}//end of cave()
		private static void exit() {
			//Label
			d[1] = "The beast has fallen! You are now able to untie and embrace your wife and son as you have finally freed them. You notice a single stream of light flowing into the cave deeper in and as you approach it with your family you realize it is a way out! You walk out with your family to begin your no longer lonesome journey home.";
			lblbox.setText(d[1]);
			//Text
			txtTop.setText("The End");
			//Box R (Directions)	
			LstR.getItems().removeAll("Go North", "Go East", "Go West", "Go South");
		}//end of mountainPass()
}//end of Main
