package com.example.findhairdresser

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.findhairdresser.data.model.CitiesAPI
import com.example.findhairdresser.data.model.cities
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Spinner içerisine koyacağımız verileri tanımlıyoruz.
val iller :  MutableList<String> = mutableListOf("ADANA","ADIYAMAN","AFYONKARAHİSAR","AĞRI","ANKARA","ANTALYA","ARTVİN","AYDIN","BALIKESİR","BİLECİK","BİNGÖL","BİTLİS","BOLU","BURDUR","BURSA","ÇANAKKALE","ÇANKIRI","ÇORUM","DENİZLİ","DİYARBAKIR","EDİRNE","ELAZIĞ","ERZİNCAN","ERZURUM","ESKİŞEHİR","GAZİANTEP","GİRESUN","GÜMÜŞHANE","HAKKARİ","HATAY","ISPARDA","MERSİN","İSTANBUL","İZMİR","KARS","KASTAMONU","KAYSERİ","KIRKLARELİ","KIRŞEHİR","KOCAELİ","KONYA","KÜTAHYA","MALATYA","MANİSA","KAHRAMANMARAŞ","MARDİN","MUĞLA","MUŞ","NEVŞEHİR","NİĞDE","ORDU","RİZE","SAKARYA","SAMSUN","SİİRT","SİNOP","SİVAS","TEKİRDAĞ","TOKAT","TRABZON","TUNCELİ","ŞANLIURFA","UŞAK","VAN","YOZGAT","ZONGULDAK","AKSARAY","BAYBURT","KARAMAN","KIRIKKALE","BATMAN","ŞIRNAK","BARTIN","ARDAHAN","IĞDIR","YALOVA","KARABÜK","KİLİS","OSMANİYE","DÜZCE")
val ilceler0:  MutableList<String> = mutableListOf("SEYHAN","YÜREĞİR","ÇUKUROVA","CEYHAN","SARIÇAM","KOZAN","İMAMOĞLU","KARATAŞ","KARAİSALI","POZANTI","YUMURTALIK","TUFANBEYLİ","FEKE","ALADAĞ","SAİMBEYLİ")
val ilceler1 :  MutableList<String> = mutableListOf("MERKEZ","KAHTA","BESNİ","GÖLBAŞI","GERGER","SİNCİK","ÇELİKHAN","TUT","SAMSAT")
val ilceler2 :  MutableList<String> = mutableListOf("MERKEZ","SANDIKLI","DİNAR","BOLVADİN","SİNANPAŞA","EMİRDAĞ","ŞUHUT","ÇAY","İHSANİYE","İSCEHİSAR","SULTANDAĞI","ÇOBANLAR","DAZKIRI","BAŞMAKÇI","HOCALAR","BAYAT","EVCİLER","KIZILÖREN")
val ilceler3 :  MutableList<String> = mutableListOf("MERKEZ","PATNOS","DOĞUBAYAZIT","DİYADİN","ELEŞKİRT","TUTAK","TAŞLIÇAY","HAMUR")
val ilceler4 :  MutableList<String> = mutableListOf("MERKEZ","MERZİFON","SULUOVA","TAŞOVA","GÜMÜŞHACIKÖY","GÖYNÜCEK","HAMAMÖZÜ")
val ilceler5 :  MutableList<String> = mutableListOf("ÇANKAYA","KEÇİÖREN","YENİMAHALLE","MAMAK","ETİMESGUT","SİNCAN","ALTINDAĞLAR","PURSAKLAR","GÖLBAŞI","POLATLI","ÇUBUK","KAHRAMANKAZAN","BEYPAZARI","ELMADAĞ","ŞEREFLİKOÇHİSAR","AKYURT","NALLIHAN","HAYMANA","KIZILCIHAMAM","BALA","KALECİK","AYAŞ","GÜDÜL","ÇAMLIDERE","EVREN")
val ilceler6 :  MutableList<String> = mutableListOf("KEPEZ","MURATAPAŞA","ALANYA","MANAVGAT","KONYAALTI","SERİK","AKSU","KUMLUCA","DÖŞEMEALTI","KAŞ","KORKUTELİ","GAZİPAŞA","FİNİKE","KEMER","ELMALI","DEMRE","AKSEKİ","GÜNDOĞMUŞ","İBRADI")
val ilceler7 :  MutableList<String> = mutableListOf("HOPA","MERKEZ","BORÇKA","YUSUFELİ","ARHAVİ","ŞAVŞAT","ARDANUÇ","MURGUL")
val ilceler8 :  MutableList<String> = mutableListOf("EFELER","NAZİLLİ","SÖKE","KUŞADASI","DİDİM","ÇİNE","İNCİRLİOVA","GERMENCİK","KÖŞK","KUYUCAK","SULTANHİSAR","KARACASU","YENİPAZAR","BUHARKENT","KARPUZLU")
val ilceler9 :  MutableList<String> = mutableListOf("KARESİ","ALTIEYLÜL","EDREMİT","GÖNEN","AYVALIK","BURHANİYE","BİGADİÇ","SUSURLUK","DURSUNBEY","SINDIRGI","İVRİNDİ","ERDEK","HAVRAN","KEPSUT","MANYAS","SAVAŞTEPE","BALYA","GÖMEÇ","MARMARA")
val ilceler10 :  MutableList<String> = mutableListOf("MERKEZ","BOZÜYÜK","OSMANELİ","SÖĞÜT","GÖLPAZARI","PAZARYERİ","YENİPAZAR","İNHİSAR")
val ilceler11 :  MutableList<String> = mutableListOf("MERKEZ","GENÇ","SOLHAN","KARLIOVA","ADAKLI","KİĞI","YEDİSU","YAYLADERE")
val ilceler12 :  MutableList<String> = mutableListOf("TATVAN","MERKEZ","GÜROYMAN","AHLAT","HİZAN","MUTKİ","ADİLCEVAZ")
val ilceler13 :  MutableList<String> = mutableListOf("MERKEZ","GEREDE","MUDURNU","GÖYNÜK","MENGEN","YENİÇAĞA","DÖRTDİVAN","SEBEN","KIBRISCIK")
val ilceler14 :  MutableList<String> = mutableListOf("MERKEZ","BUCAK","GÖLHİSAR","YEŞİLOVA","ÇAVDIR","TEFENNİ","AĞLASUN","KARAMANLI","ALTINYAYLA","ÇELTİKÇİ","KEMER")
val ilceler15 :  MutableList<String> = mutableListOf("OSMANGAZİ","YILDIRIM","GEMLİK","MUSTAFA KEMAL PAŞA","MUDANYA","GÜRSU","KARACABEY","ORHANGAZİ","KESTEL","YENİŞEHİR","İZNİK","ORHANELİ","KELES","BÜYÜKORHAN","HARMANCIK")
val ilceler16 :  MutableList<String> = mutableListOf("MERKEZ","BİGA","ÇAN","GELİBOLU","YENİCE","AYVACIK","EZİNE","BAYRAMİÇ","LAPSEKİ","ECEABAT","GÖKÇEADA","BOZCAADA")
val ilceler17 :  MutableList<String> = mutableListOf("MERKEZ","ÇERKEŞ","ILGAZ","ORTA","ŞABANÖZÜ","KURŞUNLU","YAPRAKLI","KIZILIRMAK","ATKARACALAR","ELDİVAN","KORGUN","BAYRAMÖREN")
val ilceler18 :  MutableList<String> = mutableListOf("MERKEZ","SUNGURLU","OSMANCIK","İSKİLİP","ALACAK","BAYAT","MECİTÖZÜ","KARGI","ORTAKÖY","UĞURLUDAĞ","DODURGA","OĞUZLAR","LAÇİN","BOĞAZKALE")
val ilceler19 :  MutableList<String> = mutableListOf("PAMUKKALE","MERKEZEFENDİ","ÇİVRİL","ACIPAYAM","TAVAS","HONAZ","SARAYKÖY","BULDAN","KALE","ÇAL","ÇAMELİ","SERİNHİSAR","BOZKURT","GÜNEY","ÇARDAK","BEKİLLİ","BEYAĞAÇ","BABADAĞ","BAKLAN")
val ilceler20 :  MutableList<String> = mutableListOf("BAĞLAR","KAYAPINAR","YENİŞEHİR","ERGANİ","SUR","BİSMİL","SİLVAN","ÇINAR","ÇERMİK","DİCLE","KULP","HANİ","LİCE","EĞİL","HAZRO","KOCAKÖY","ÇÜNGÜŞ")
val ilceler21 :  MutableList<String> = mutableListOf("MERKEZ","KEŞAN","UZUNKÖPRÜ","İPSALA","HAVSA","MERİÇ","ENEZ","SÜLOĞLU","LALAPAŞA")
val ilceler22 :  MutableList<String> = mutableListOf("MERKEZ","KOVANCILAR","PALU","ARICAK","BASKİL","MADEN","SİVRİCE","ALACAKAYA","KEBAN","AĞIN")
val ilceler23 :  MutableList<String> = mutableListOf("MERKEZ","TERCAN","ÜZÜMLÜ","ÇAYIRLI","İLİÇ","KEMAH","KEMALİYE","OTLUKBELİ")
val ilceler24 :  MutableList<String> = mutableListOf("YAKUTİYE","PALANDÖKEN","AZİZİYE","HORASAN","OLTU","PASİNLER","KARAYAZI","HINIS","TEKMAN","KARAÇOBAN","AŞKALE","ŞENKAYA","ÇAT","KÖPRÜKÖY","İSPİR","TORTUM","NARMAN","UZUNDERE","OLUR","PAZARYOLU")
val ilceler25 :  MutableList<String> = mutableListOf("ODUNPAZARI","TEPEBAŞI","SİVRİHİSAR","ÇİFTELER","SEYİTGAZİ","ALPU","MİHALIÇÇIK","MAHMUDİYE","BEYLİKOVA","İNÖNÜ","SARICAKAYA","GÜNYÜZÜ","MİHALGAZİ","HAN")
val ilceler26 :  MutableList<String> = mutableListOf("ŞAHİNBEY","ŞEHİTKAMİL","NİZİP","İSLAHİYE","NURDAĞI","ARABAN","OĞUZELİ","YAVUZELİ","KARKAMIŞ")
val ilceler27 :  MutableList<String> = mutableListOf("MERKEZ","BULANCAK","ESPİYE","GÖRELE","TİREBOLU","DERELİ","ŞEBİNKARAHİSAR","KEŞAP","YAĞLUDERE","ALUCRA","PİRAZİZ","EYNESİL","GÜCE","ÇANAKÇI","DOĞANKENT","ÇAMOLUK")
val ilceler28 :  MutableList<String> = mutableListOf("MERKEZ","KELKİT","ŞİRAN","KÜRTÜN","TORUL","KÖSE")
val ilceler29 :  MutableList<String> = mutableListOf("YÜKSEKOVA","MERKEZ","ÇUKURCA","ŞEMDİNLİ")
val ilceler30 :  MutableList<String> = mutableListOf("ANTAKYA","İSKENDERUN","DEFNE","DÖRTYOL","SAMANDAĞ","KIRIKHAN","REYHANLI","ARSUZ","ALTINÖZÜ","HASSA","ERZİN","PAYAS","BELEN","YAYLADAĞI","KUMLU")
val ilceler31 :  MutableList<String> = mutableListOf("MERKEZ","YALVAÇ","EĞİRDİR","ŞARKİKARAAĞAÇ","GELENDOST","KEÇİBORLU","SENİRKENT","SÜTÇÜLER","GÖNEN","ULUBORLU","ATABEY","AKSU","YENİŞARBADEMLİ")
val ilceler32 :  MutableList<String> = mutableListOf("TARSUS","TOROSLAR","AKDENİZ","YENİŞEHİR","MEZİTLİ","ERDEMLİ","SİLİFKE","ANAMUR","MUT","BOZYAZI","GÜLNAR","AYDINCIK","ÇAMLIYAYLA")
val ilceler33 :  MutableList<String> = mutableListOf("ESENYURT","KÜÇÜKÇEKMECE","BAĞCILAR","ÜMRANİYE","PENDİK","BAHÇELİEVLER","ÜSKÜDAR","SULTANGAZİ","GAZİOSMANPAŞA","MALTEPE","KARTAL","ESENLER","KADIKÖY","KAĞITHANE","AVCILAR","ATAŞEHİR","FATİH","EYÜP","SANCAKTEPE","BAŞAKŞEHİR","SARIYER","SULTANBEYLİ","GÜNGÖREN","BEYLİKDÜZÜ","ZEYTİNBURNU","BAYRAMPAŞA","ŞİŞLİ","BEYKOZ","ARNAVUTKÖY","TUZLA","ÇEKMEKÖY","BEYOĞLU","BÜYÜKÇEKMECE","BAKIRKÖY","BEŞİKTAŞ","SİLİVRİ","ÇATALCA","ŞİLE","ADALAR")
val ilceler34 :  MutableList<String> = mutableListOf("BUCA","KARABAĞLAR","BORNOVA","KONAK","KARŞIYAKA","BAYRAKLI","ÇİĞLİ","TORBALI","MENEMEN","GAZİEMİR","ÖDEMİŞ","KEMALPAŞA","BERGAMA","ALİAĞA","MENDERES","TİRE","BALÇOVA","NARLIDERE","URLA","KİRAZ","DİKİLİ","ÇEŞME","BAYINDIR","SEFERİHİSAR","SELÇUK","GÜZELBAHÇE","FOÇA","KINIK","BEYDAĞ","KARABURUN")
val ilceler35 :  MutableList<String> = mutableListOf("MERKEZ","KAĞIZMAN","SARIKAMIŞ","SELİM","DİGOR","ARPAÇAY","AKYAKA","SUSUZ")
val ilceler36 :  MutableList<String> = mutableListOf("MERKEZ","TOSYA","TAŞKÖPRÜ","CİDE","İNEBOLU","ARAÇ","DEVREKANİ","BOZKURT","DADAY","AZDAVAY","ÇATALZEYTİN","KÜRE","DOĞANYURT","İHSANGAZİ","PINARBAŞI","ŞENPAZAR","ABANA","SEYDİLER","HANÖNÜ","AĞLI")
val ilceler37 :  MutableList<String> = mutableListOf("MELİKGAZİ","KOCASİNAN","TALAS","DEVELİ","YAHYALI","BÜNYAN","İNCESU","PINARBAŞI","TOMARZA","YEŞİLHİSAR","SARIOĞLAN","HACILAR","SARIZ","AKKIŞLA","FELAHİYE","ÖZVATAN")
val ilceler38 :  MutableList<String> = mutableListOf("LÜLEBURGAZ","MERKEZ","BABAESKİ","VİZE","PINARHİSAR","DEMİRKÖY","PEHLİVANKÖY","KOFÇAZ")
val ilceler39 :  MutableList<String> = mutableListOf("MERKEZ","KAMAN","MUCUR","ÇİÇEKDAĞI","AKPINAR","BOZTEPE","AKÇAKENT")
val ilceler40 :  MutableList<String> = mutableListOf("GEBZE","İZMİT","DARICA","KÖRFEZ","GÖLCÜK","DERİNCE","ÇAYIROVA","KARTEPE","BAŞİSKELE","KARAMÜRSEL","KANDIRA","DİLOVASI")
val ilceler41 :  MutableList<String> = mutableListOf("SELÇUKLU","MERAM","KARATAY","EREĞLİ","AKŞEHİR","BEYŞEHİR","ÇUMRA","SEYDİŞEHİR","ILGIN","CİHANBEYLİ","KULU","KARAPINAR","KADINHANI","SARAYÖNÜ","BOZKIR","YUNAK","DOĞANHİSAR","HÜYÜK","ALTINEKİN","HADİM","ÇELTİK","EMİRGAZİ","TUZLUKÇU","DEREBUCAK","AKÖREN","HALKAPINAR","YALIHÜYÜK")
val ilceler42 :  MutableList<String> = mutableListOf("MERKEZ","TAVŞANLI","SİMAV","GEDİZ","EMET","ALTINTAŞ","DOMANİÇ","HİSARCIK","ASLANAPA","ÇAVDARHİSAR","ŞAPHANE","PAZARLAR","DUMLUPINAR")
val ilceler43 :  MutableList<String> = mutableListOf("BATTALGAZİ","YEŞİLYURT","DOĞANŞEHİR","AKÇADAĞ","HEKİMHAN","PÜTÜRGE","YAZIHAN","ARAPGİR","ARGUVAN","KULUNCAK","KALE","DOĞANYOL")
val ilceler44 :  MutableList<String> = mutableListOf("YUNUSEMRE","ŞEHZADELER","AKHİSAR","SALİHLİ","TURGUTLU","SOMA","ALAŞEHİR","SARUHANLI","KULA","KIRKAĞAÇ","DEMİRCİ","SARIGÖL","GÖRDES","SELENDİ","AHMETLİ","GÖLMARAMARA","KÖPRÜBAŞI")
val ilceler45 :  MutableList<String> = mutableListOf("ONİKİŞUBAT","DULKADİROĞLU","ELBİSTAN","AFŞİN","TÜRKOĞLU","PAZARCIK","GÖKSUN","ANDIRIN","ÇAĞLAYANCERİT","NURHAK","EKİNÖZÜ")
val ilceler46 :  MutableList<String> = mutableListOf("KIZILTEPE","ARTUKLU","MİDYAT","NUSAYBİN","DERİK","MAZIDAĞI","DARGEÇİT","SAVUR","YEŞİLLİ","ÖMERLİ")
val ilceler47 :  MutableList<String> = mutableListOf("BODRUM","FEYHİYE","MİLAS","MENTEŞE","MARMARİS","SEYDİKEMER","ORTACA","YATAĞAN","DALAMAN","KÖYCEĞİZ","ULA","DATÇA","KAVAKLIDERE")
val ilceler48 :  MutableList<String> = mutableListOf("MERKEZ","BULANIK","MALAZGİRT","VARTO","HASKÖY","KORKUT")
val ilceler49 :  MutableList<String> = mutableListOf("MERKEZ","ÜRGÜP","AVANOS","GÜLŞEHİR","DERİNKUYU","ACIGÖL","KOZAKLI","HACIBEKTAŞ")
val ilceler50 :  MutableList<String> = mutableListOf("MERKEZ","BOR","ÇİFTLİK","ULUKIŞLA","ALTUNHİSAR","ÇAMARLDI")
val ilceler51 :  MutableList<String> = mutableListOf("ALTINORDU","ÜNYE","FATSA","GÖLKÖY","PERŞEMBE","KUMRU","AYBASTI","KORGAN","AKKUŞ","ULUBEY","MESUDİYE","İKİZCE","GÜRGENTEPE","ÇATALPINAR","ÇAYBAŞI","KABATAŞ","ÇAMAŞ","GÜLYALI")
val ilceler52 :  MutableList<String> = mutableListOf("MERKEZ","ÇAYELİ","ARDEŞEN","PAZAR","FINDIKLI","GÜNEYSU","KALKANDERE","İYİDERE","DEREPAZARI","ÇAMLIHEMŞİN","İKİZDERE","HEMŞİN")
val ilceler53 :  MutableList<String> = mutableListOf("ADAPAZARI","SERDİVAN","AKYAZI","ERENLER","HENDEK","KARASU","GEYVE","ARİFİYE","SAPANCA","PAMUKOVA","FERİZLİ","KAYNARCA","KACAALİ","KARAPÜRÇEK","TARAKLI")
val ilceler54 :  MutableList<String> = mutableListOf("İLKADIM","ATAKUM","BAFRA","ÇARŞAMBA","CANİK","VERİZKÖPRÜ","TERME","TEKKEKÖY","HAVZA","ALAÇAM","19MAYIS","AYVACIK","KAVAK","SALIPAZARI","ASARCIK","LADİK","YAKAKENT")
val ilceler55 :  MutableList<String> = mutableListOf("MERKEZ","KURTALAN","PERVARİ","BAYKAN","ŞİRVAN","ERUH","TİLLO")
val ilceler56 :  MutableList<String> = mutableListOf("MERKEZ","BOYABAT","GERZE","AYANCIK","DURAĞAN","TÜRKELİ","ERFELEK","DİKMEN","SARAYDÜZÜ")
val ilceler57 :  MutableList<String> = mutableListOf("MERKEZ","ŞARKIŞLA","YILDIZELİ","SUŞEHRİ","GEMEREK","ZARA","KANGAL","GÜRÜN","DİVRİĞİ","KOYULHİSAR","ALTINYAYLA","HAFİK","ULAŞ","İMRANLI","AKINCILAR","GÜLOVA","DOĞANŞAR")
val ilceler58 :  MutableList<String> = mutableListOf("ÇORLU","SÜLEYMANPAŞA","ÇERKEZKÖY","KAPAKLI","ERGENE","MALKARA","SARAY","HAYRABOLU","ŞARKÖY","MURATLI","MARMARAEREĞLİSİ")
val ilceler59 :  MutableList<String> = mutableListOf("MERKEZ","ERBAA","TURHAL","NİKSAR","ZİLE","REŞADİYE","ALMUS","PAZAR","BAŞÇİFTLİK","YEŞİLYURT","ARTOVA","SULUSARAY")
val ilceler60 :  MutableList<String> = mutableListOf("ORTAHİSAR","AKÇAABAT","ARAKLI","OF","YOMRA","ARSİN","VAKFIKEBİR","SÜRMENE","MAÇKA","BEŞİKDÜZÜ","ÇARŞIBAŞI","TONYA","DÜZKÖY","ÇAYKARA","ŞALPAZARI","HAYRAT","KÖPRÜBAŞI","DERNEKPAZARI")
val ilceler61 :  MutableList<String> = mutableListOf("MERKEZ","PERTEK","MAZGİRT","ÇEMİŞGEZEK","HOZAT","OVACIK","PÜLÜMÜR","NAZIMİYE")
val ilceler62 :  MutableList<String> = mutableListOf("EYYÜBİYE","HALİLİYE","SİVEREK","VİRANŞEHİR","KARAKÖPRÜ","AKÇAKALE","SURUÇ","BİRECİK","CEYLANPINAR","HARRAN","BOZOCA","HİLVAN","HALFETİ")
val ilceler63 :  MutableList<String> = mutableListOf("MERKEZ","BANAZ","EŞME","SİVASLI","ULUBEY","KARAHALLI")
val ilceler64 :  MutableList<String> = mutableListOf("İPEKYOLU","ERCİŞ","TUŞBA","EDREMİT","ÖZALP","ÇALDIRAN","BAŞKALE","MURADİYE","GÜRPINAR","GEVAŞ","SARAY","ÇATAK","BAHÇESARAY")
val ilceler65 :  MutableList<String> = mutableListOf("MERKEZ","SORGUN","AKDAĞMADENİ","YERKÖY","SARIKAYA","BOĞAZLIYAN","ÇEKEREK","ŞEFAATLİ","SARAYKENT","ÇAYIRALAN","KADIŞEHİR","AYDINCIK","YENİFAKILLI","ÇANDIR")
val ilceler66 :  MutableList<String> = mutableListOf("EREĞLİ","MERKEZ","ÇAYCUMA","DEVREK","KOZLU","ALAPLI","KİLİMLİ","GÖKÇEBEY")
val ilceler67 :  MutableList<String> = mutableListOf("MERKEZ","ORTAKÖY","ESKİL","GÜLAĞAÇ","GÜZELYURT","AĞAÇÖREN","SARIYAHŞİ")
val ilceler68 :  MutableList<String> = mutableListOf("MERKEZ","DEMİRÖZÜ","AYDINTEPE")
val ilceler69 :  MutableList<String> = mutableListOf("MERKEZ","ERMENEK","SARIEVLER","AYRANCI","KAZIMKARABEKİR","BAŞYAYLA")
val ilceler70 :  MutableList<String> = mutableListOf("MERKEZ","YAHŞİHAN","KESKİN","DELİCE","BAHŞİLİ","SULAKYURT","BALIŞEYH","KARAKEÇİLİ","ÇELEBİ")
val ilceler71 :  MutableList<String> = mutableListOf("MERKEZ","KOZLUK","BEŞİRİ","SASON","GERÇÜŞ","HASANKEYF")
val ilceler72 :  MutableList<String> = mutableListOf("CİZRE","SİLOPİ","MERKEZ","İDİL","ULUDERE","BEYTÜŞŞEBAP","GÜÇLÜKONAK")
val ilceler73 :  MutableList<String> = mutableListOf("MERKEZ","ULUS","AMASRA","KURUCAŞİLE")
val ilceler74 :  MutableList<String> = mutableListOf("MERKEZ","GÖLE","ÇILDIR","HANAK","POSOF","DAMAL")
val ilceler75 :  MutableList<String> = mutableListOf("MERKEZ","TUZLUCA","ARALIK","KARAKOYUNLU")
val ilceler76 :  MutableList<String> = mutableListOf("MERKEZ","ÇİFTLİKKÖY","ÇINARCIK","ALTINOVA","ARMUTLU","TERMAL")
val ilceler77 :  MutableList<String> = mutableListOf("MERKEZ","SAFRANBOLU","YENİCE","ESKİPAZAR","EFLANİ","OVACIK")
val ilceler78 :  MutableList<String> = mutableListOf("MERKEZ","MUSABEYLİ","ELBEYLİ","POLATELİ")
val ilceler79 :  MutableList<String> = mutableListOf("MERKEZ","KADİRLİ","DÜZİÇİ","BAHÇE","TOPRAKKALE","SUMBAS","HASANBEYLİ")
val ilceler80 :  MutableList<String> = mutableListOf("MERKEZ","AKÇAKOCA","KAYNAŞLI","GÖLYAKA","ÇİLİMLİ","YIĞILCA","GÜMÜŞOVA","CUMAYERİ")

//Spinner'ları ve Adapter'lerini tanımlıyoruz.
lateinit var spinnerIller : Spinner
lateinit var spinnerIlceler : Spinner
lateinit var dataAdapterForIller : android.widget.ArrayAdapter<String>
lateinit var dataAdapterForIlceler : ArrayAdapter<String>



class choosingLocation : AppCompatActivity() {
    private val Cities : ArrayList<cities>?= null
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing_location)


          //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        /*spinnerIller = findViewById(R.id.spinner1)
        spinnerIlceler = findViewById(R.id.spinner2)

      //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForIller = ArrayAdapter(this,android.R.layout.simple_spinner_item,iller)
        dataAdapterForIlceler = ArrayAdapter(this, android.R.layout.simple_spinner_item, ilceler0);


      //Listelenecek verilerin görünümünü belirliyoruz.
      dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
      dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

      //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
      spinnerIller.setAdapter(dataAdapterForIller)
      spinnerIlceler.setAdapter(dataAdapterForIlceler)

      // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
      spinnerIller.setOnItemSelectedListener(new OnItemSelectedListener() {

          @Override
          public void onItemSelected(AdapterView<?> parent, View view,
              int position, long id) {
              //Hangi il seçilmişse onun ilçeleri adapter'e ekleniyor.
              for(i==0; i<=80;i++){
              if(parent.getSelectedItem().toString().equals(iller[i]))
                  dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ilceler"$i");
              }

              dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
              spinnerIlceler.setAdapter(dataAdapterForIlceler);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {
          }
      });

      spinnerIlceler.setOnItemSelectedListener(new OnItemSelectedListener() {

          @Override
          public void onItemSelected(AdapterView<?> parent, View view,
              int position, long id) {
              //Seçilen il ve ilçeyi ekranda gösteriyoruz.
              Toast.makeText(getBaseContext(), ""+spinnerIller.getSelectedItem().toString()+"n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
          }

          public void onNothingSelected(AdapterView<?> parent) {
          }
      });*/
        loadData()
}
    private fun loadData(){

        val retrofit = Retrofit.Builder().baseUrl(R.raw.cities.toString()).addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create((CitiesAPI::class.java))
        val call = service.getData()
        call.enqueue(object: Callback<List<cities>>{
            override fun onResponse(call: Call<List<cities>>?, response: Response<List<cities>>?) {

            }

            override fun onFailure(call: Call<List<cities>>?, response: Response<List<cities>>) {
                if(response.isSuccessful){
                    response.body()?.let {


                    }
                }
            }

        })
    }

}
