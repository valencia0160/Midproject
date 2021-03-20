import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<String> kodeKaryawan = new Vector<String>();
	Vector<String> namaKaryawan = new Vector<String>();
	Vector<String> jenisKelamin = new Vector<String>();
	Vector<String> jabatanKaryawan = new Vector<String>();
	Vector<Double> gajiKaryawan = new Vector<Double>();

	String nama="";
	String gender="";
	String jabatan="";
	double gaji=0;
	double bonus=0;

	public Main() {
		int pilih = 0;
		System.out.println("PT Mentol");
		System.out.print("1. Input data");
		System.out.print("2. View data");
		System.out.print("3. Update data");
		System.out.print("4. Delete data");
		System.out.print(">> ");
		pilih = tryCatch();

		switch (pilih) {
		case 1:
			String kode="";
			String mm="";
			int xxxx;
			String[] code = kode.split("-");
			mm = code[0];
			xxxx = Integer.parseInt(code[1]);

			Random rand = new Random();
			String mm1 = ("a"+ rand.nextInt(26));
			String mm2 = ("a"+ rand.nextInt(26));
			do {
				mm = mm1+mm2;
			} while (mm1==mm2);

			int xxxx1 = 1 + rand.nextInt(10);
			int xxxx2 = 1 + rand.nextInt(10);
			int xxxx3 = 1 + rand.nextInt(10);
			int xxxx4 = 1 + rand.nextInt(10);
			do {
				xxxx = xxxx1+xxxx2+xxxx3+xxxx4;
			} while (xxxx1==xxxx2 || xxxx1==xxxx3 || xxxx1==xxxx4 || xxxx2==xxxx3 || xxxx2==xxxx4 || xxxx3==xxxx4);
			kode = mm+"-"+xxxx;

			userInput();

			if(jabatan.equals("Manager")) {
				gaji = 8000000;
				bonus = 0.1;
				if (jabatanKaryawan.size()%3!=0) {
					gaji=8000000+(0.1*8000000);
				}
			} else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
				bonus = 0.075;
				if (jabatanKaryawan.size()%3!=0) {
					gaji=6000000+(0.075*6000000);
				}
			} else if (jabatan.equals("Admin")) {
				gaji = 4000000;
				bonus = 0.5;
				if (jabatanKaryawan.size()%3!=0) {
					gaji=4000000+(0.05*4000000);
				}	
			}

			kodeKaryawan.add(kode);
			namaKaryawan.add(nama);
			jenisKelamin.add(gender);
			jabatanKaryawan.add(jabatan);
			gajiKaryawan.add(gaji);

			System.out.println("Berhasil menambahkan karyawan dengan id "+kode);
			System.out.println("Bonus sebesar "+bonus+" telah diberikan kepada karyawan dengan id " + kode );
			System.out.println("ENTER to return");

			scan.nextLine();
			scan.nextLine();
			break;



		case 2: 
			sort(namaKaryawan, nama.length());
			for (int i = 0; i < namaKaryawan.size(); i++) {
				System.out.println("No. "+i+1);
				System.out.println("Kode Karyawan: "+ kodeKaryawan);
				System.out.println("Nama Karyawan: "+ namaKaryawan);
				System.out.println("Jenis Kelamin: "+ jenisKelamin);
				System.out.println("Jabatan      : "+ jabatanKaryawan);
				System.out.println("Gaji Karyawan: "+ gajiKaryawan);
			}
			break;


		case 3:
			sort(namaKaryawan, nama.length());
			for (int i = 0; i < namaKaryawan.size(); i++) {
				System.out.println("No. "+i+1);
				System.out.println("Kode Karyawan: "+ kodeKaryawan);
				System.out.println("Nama Karyawan: "+ namaKaryawan);
				System.out.println("Jenis Kelamin: "+ jenisKelamin);
				System.out.println("Jabatan      : "+ jabatanKaryawan);
				System.out.println("Gaji Karyawan: "+ gajiKaryawan);
			}

			int update=0;
			System.out.print("Input angka yang ingin di update: ");
			update = tryCatch();
			for (int i = 0; i < namaKaryawan.size(); i++) {
				if (update==i) {
					userInput();
				}
			}
			break;


		case 4:
			int delete=0;
			sort(namaKaryawan, nama.length());
			for (int i = 0; i < namaKaryawan.size(); i++) {
				System.out.println("No. "+i+1);
				System.out.println("Kode Karyawan: "+ kodeKaryawan);
				System.out.println("Nama Karyawan: "+ namaKaryawan);
				System.out.println("Jenis Kelamin: "+ jenisKelamin);
				System.out.println("Jabatan      : "+ jabatanKaryawan);
				System.out.println("Gaji Karyawan: "+ gajiKaryawan);
			}
			System.out.print("Input angka yang ingin di delete: ");
			delete= tryCatch();

			for (int i = 0; i < namaKaryawan.size(); i++) {
				if (delete==i) {
					namaKaryawan.remove(i);
					jenisKelamin.remove(i);
					jabatanKaryawan.remove(i);
					gajiKaryawan.remove(i);
				}
			}

		}


	}
	public void userInput () {
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		} while (nama.length()<3);


		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		} while (!gender.equals("Laki-laki")&&!gender.equals("Perempuan"));


		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
			jabatan = scan.nextLine();
		} while (!jabatan.equals("Manager")&&!jabatan.equals("Supervisor")&&!jabatan.equals("Admin"));
	}

	public int tryCatch () {
		int a;
		try {
			a = scan.nextInt(); scan.nextLine();
		} catch (Exception e) {
			a = -1;
			scan.nextLine();
		} return a;
	}


	public void sort (Vector<String> name, int size) {
		for (int i = 0; i < size -1; i++) {
			for (int j = 0; j < size -1; j++) {
				String name1 = name.get(j);
				String name2 = name.get(j+1);
				if(name1.compareTo(name2)>0) {
					name.set(j, name2);
					name.set(j+1, name1);
				}

			}
		}
	}

	public static void main(String[] args) {
		new Main();

	}

}
