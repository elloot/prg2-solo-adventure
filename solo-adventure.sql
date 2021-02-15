-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: solo-adventure
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `links`
--

DROP TABLE IF EXISTS `links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `links` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `story_id` int unsigned DEFAULT NULL,
  `target_id` int unsigned DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `story_id` (`story_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `links`
--

LOCK TABLES `links` WRITE;
/*!40000 ALTER TABLE `links` DISABLE KEYS */;
INSERT INTO `links` VALUES (1,1,2,'Spring efter pojken'),(2,1,3,'Gå vidare'),(3,3,4,'Tänd en sticka'),(4,3,5,'Spara stickorna'),(5,5,6,'Knacka på fönstret'),(6,5,7,'Gå vidare'),(7,7,4,'Tänd en sticka'),(8,4,8,'Nästa'),(9,8,9,'Nästa'),(10,9,10,'Nästa'),(11,10,11,'Nästa');
/*!40000 ALTER TABLE `links` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story`
--

DROP TABLE IF EXISTS `story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `story` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `body` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story`
--

LOCK TABLES `story` WRITE;
/*!40000 ALTER TABLE `story` DISABLE KEYS */;
INSERT INTO `story` VALUES (1,'Det är nyårsafton. Det är kallt ute och du springer över gatan. Du tappar de stora tofflorna du fick låna av din mamma; den ena kan du inte hitta och den andra springer en liten pojke fram och tar. Springer du efter pojken eller går du vidare?'),(2,'Du blir arg på pojken och bestämmer dig för att springa efter honom och ta tillbaka din mammas toffla. Förblindad av din ilska springer du rätt ut i gatan och blir påkörd av en bil. Krocken är dödlig och ditt äventyr tar slut här'),(3,'Du bestämmer dig för att gå vidare utan dina tofflor. Dina fötter blir blå av kölden och du bestämmer dig för att hitta ett gathörn att vila i. Du vågar inte gå hem, där skulle du bli slagen för att du inte sålt några av de svavelstickor du har med dig i ditt gamla förkläde. När du satt dig ner är du kallare än någonsin och du funderar på att tända en sticka för att värma dig. Tänder du en sticka?'),(4,'Du tar hastigt fram en sticka ur ditt förkläde och drar den mot väggen. Lågan brinner varmt och klart, som ett litet ljus. Du tycker dig sitta framför en stor järnkamin med blanka mässingsknappar. Elden värmer dig så härligt och gott och du ska precis sträcka fram dina fötter för att värma dem också när svavelstickan slocknar och kaminen försvinner. Där sitter du nu, med en stump av en svavelsticka i ett mörkt gatuhörn.'),(5,'Du blir rädd för det dina föräldrar skulle göra om du kom hem med en sticka för lite. Istället bestämmer du dig för att gå till ett hus du gått förbi tidigare där de hade haft en stor, saftig gås. Du tänker att de kanske kan ge dig en bit när de ser hur illa därann du är.\r\nNär du kommer fram till huset knackar du på dörren men ingen öppnar. Du tänker att du kan kika in genom fönstret och försöka få kontakt med dem där inne på det viset. Knackar du på fönstret?'),(6,'Du går försöktigt fram till fönstret och kikar in genom rutan. Där inne sitter en familj vid ett matbord framför en brasa med den finaste maten du någonsin sätt. De har gås, potatis, köttbullar, prinskorv och all annan julmat du kan tänka dig (trots att det är nyårsafton). Du känner att du måste knacka på rutan och för din hand mot glaset. Precis innan du ska knacka till hur du en smäll från en bils avgasrör och hoppar till. Du råkar ramla in i fönstret och krossar rutan i tusen bitar. Familjen där inne blir förskräckt när de ser dig falla ner på golvet och ringer genast polisen. Du blir arresterad för försök till rån och blir satt i fängelse. Där sitter du resten av ditt liv. Ditt äventyr tar slut här.'),(7,'Du bestämmer dig för att det kanske inte var en så bra idé att tigga mat på nyårsafton ändå. När du går vidare längs gatan hur du en knall från en bils avgasrör och tror att det är ett pistolskott. Förskräckt springer du tillbaka till hörnet du satt i tidigare och blir sittande där. Efter ett tag kan du inte längre hålla dig, du är så fruktansvärt kall och en liten svavelsticka skulle ju ändå inte föräldrarna märka.'),(8,'Du tänder en till sticka. Nu ser du in i ett hus där de äter kladdkaka och ris à la Malta till efterrätt. Barnen dricker varm choklad och de vuxna har ångande kaffe i sina muggar. Du går mot väggen och känner lukten av de godaste sötsakerna. När du kliver in i rummet går du mot en ledig stol. Familjen ler vänligt mot dig och du ska precis sätta dig när stickan slocknar och du är tillbaka i gränden.'),(9,'Du stryker ännu en sticka. Den här gången är du framför den vackraste julgranen. Den är vackrare och större än den hos din rike köpmannen förra julen. Tusentals ljus brinner i de gröna grenerna och du blir helt förtrollad av dess skönhet. Du sträcker båda händerna mot luften och precis då slocknar stickan. Julljusen stiger mot himlen och när du följer dem med blicken ser du hur stjärnklar natten är. En av stjärnorna faller och du tänker \"Nu dör någon!\". Din gamla mormor hade lärt dig att när en stjärna faller går en själv upp till himlen.'),(10,'Du skyndar dig att tända ännu en svavelsticka och i skenet ser du din gamla mormor. Där står hon, skinanade, mild och god. \"Mormor!\", ropar du, \"Ta mig med dig! Jag vet att du är borta då strykstickan slocknar, borta liksom den varma kaminen, den fantastiska efterrätten och den stora, vackra julgranen!\". Du stryker hastigt eld på alla stickor du har kvar. Du gör allt för att hålla kvar mormor och stickorna lyser med sådan glans att det var ljusare än mitt på dagen. Aldrig förr hade din mormor varit så vacker, så stor. Hon lyfter upp dig på sin arm och tillsammans flyger ni i glans och glödje högt upp i himlen, bort från kölden, ångesten och hungern; upp till Gud.'),(11,'På morgonstunden efter nyårsafton hittar man dig förfrusen i gränden med ett leende på dina läppar. De ser att du bränt upp alla svavelstickor och tänker att du velat värma dig i kylan, men ingen av dem visste något om de fantastiska sakerna du fått se, eller med vilken glans du och mormor gått in i nyårsglädjen!');
/*!40000 ALTER TABLE `story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'solo-adventure'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-10 12:19:51
