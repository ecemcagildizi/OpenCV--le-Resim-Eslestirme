package deneme;

import org.opencv.core.Core; //Core OpenCV kütüphanesinin org.opencv.core paketindeki bir sınıftır.
import org.opencv.core.Core.MinMaxLocResult; // minMaxLoc yönteminin sonuçlarını saklamak için kullanılır.
import org.opencv.core.Mat; //Mat sınıfı çok boyutlu bir diziyi tutar ve görüntü depolar.
import org.opencv.core.Point; // 2 boyutlu bir noktayı temsil eder ve x,y koordinatlarını saklar.
import org.opencv.core.Scalar; // 4 elemanlı bir vektörü temsil eder ve renkleri depolar.
import org.opencv.imgcodecs.Imgcodecs; // Görüntü dosyalarını okuma ve yazma işlemleri için kullanılır.
import org.opencv.imgproc.Imgproc; // Görüntü işleme işlemi için kullanılır.

public class dene {

	public static void main(String[] args) {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // Bu ifade ile OpenCV'nin yerel kütüphanesi yüklenir ve OpenCV işlevlerini kullanılır hale getirir.
		Mat source = null; // İçinde arama yapılacak olan resmi tutan değişken.
		Mat template = null;// Aranılacak resmi tutan değişken.
		String filePath = "C:\\Sablonlar"; // Bu kısımda resimleri içeren dosyanın yolu belirtildi.
		source= Imgcodecs.imread(filePath+"21.png"); //Bu kısımda içinde arama yapılacak resim belirtildi.
		template= Imgcodecs.imread(filePath+"31.png"); //Bu kısımda içinde aranılacak resim belirtildi.
		
		Mat outputImage = new Mat(); //Bu kısımda outputImage adında yeni bir Mat nesnesi oluşturuldu.
		int machMethod = Imgproc.TM_CCOEFF; // Bu kısımda machMethod adlı bir değişken oluşturuldu ve bu değişkene Imgproc.TM_CCOEFF değeri atandı. Imgproc.TM_CCOEFF 
		// Imgproc sınıfındaki bir sabittir ve bu sabit bir şablon eşleştirme yöntemini temsil eder.
		
		Imgproc.matchTemplate(source, template, outputImage, machMethod);// Bu kısımda Imgproc sınıfının matchTemplate yöntemi çağırıldı. Bu yöntem bir görüntü içerisinde
		//belirli bir konumu bulmak için kullanılır.
		
		MinMaxLocResult mmr = Core.minMaxLoc(outputImage);// Core.minMaxLoc yöntemi bir dizideki minimum ve maksimum değerleri ve konumları bulur. Bu kısımda outputImage dizisindeki 
		//minimum ve maksimum değerler ve konumlar bulunur ve mmr nesnesine kaydedilir.
		Point matchLoc = mmr.maxLoc; // Bu ifade matchLoc adında bir Point nesnesi oluşturur ve bu nesneye mmr.Loc değerini atar. mmr değişkeni bir MinMaxLocResult nesnesidir ve 
		// maxLoc alanı bir dizideki maksimum değerin konumunu temsil eder.
		
		Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows()), new Scalar(255,255,255));// Bu kısımda belirtilen yöntem belirli bir 
		// konumda dikdörtgen çizer. Dikdörtgenin rengi ise new Scalar(255,255,255) ile belirlenir ve bu renk beyazdır.
		
		Imgcodecs.imwrite(filePath+"sonuc.png",source);// Bu kısımda elde edilen sonuç yukarıda belirtilen dosyaya sonuc.png ismi ile kaydedilir.
		System.out.println("İşlem Tamamlandı");

	}

}
