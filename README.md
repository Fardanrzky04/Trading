Simulasi Trading
Kode Python di atas adalah sebuah **simulasi sederhana untuk menentukan waktu terbaik dalam membeli dan menjual saham** agar mendapatkan keuntungan maksimum.  

---

## **Penjelasan Codingan**  

### **1. Fungsi `trading_saham(harga)`**  
Fungsi ini menerima **list harga saham** dari beberapa hari dan mencari kapan waktu terbaik untuk membeli dan menjual agar mendapatkan keuntungan maksimal.  

#### **Bagian-Bagian Fungsi**  
- **Cek jumlah data harga saham**  
  ```python
  if len(harga) < 2:
      return "Data harga saham tidak cukup!"
  ```  
  Jika hanya ada **satu harga atau kurang**, maka tidak mungkin melakukan transaksi, sehingga program akan mengembalikan pesan error.  

- **Inisialisasi variabel**  
  ```python
  min_harga = harga[0]  # Harga beli awal
  max_keuntungan = 0     # Keuntungan maksimum
  hari_beli = 0
  hari_jual = 0
  ```  
  - `min_harga`: Menyimpan harga saham terendah yang ditemukan sejauh ini.  
  - `max_keuntungan`: Menyimpan keuntungan maksimal yang bisa didapatkan.  
  - `hari_beli` dan `hari_jual`: Menyimpan indeks hari beli dan jual terbaik.  

- **Looping untuk mencari harga beli dan jual terbaik**  
  ```python
  for i in range(1, len(harga)):
  ```  
  Loop ini berjalan dari hari ke-2 sampai terakhir untuk membandingkan harga saham sebelumnya.  

  - **Mencari harga beli terendah**  
    ```python
    if harga[i] < min_harga:
        min_harga = harga[i]
        hari_beli = i
    ```  
    Jika menemukan harga saham yang lebih murah, maka update `min_harga` dan hari beli (`hari_beli`).  

  - **Menghitung keuntungan jika jual di hari ini**  
    ```python
    keuntungan = harga[i] - min_harga
    if keuntungan > max_keuntungan:
        max_keuntungan = keuntungan
        hari_jual = i
    ```  
    - Keuntungan dihitung dari **selisih harga jual dan harga beli terendah sebelumnya**.  
    - Jika keuntungan lebih besar dari sebelumnya, update `max_keuntungan` dan `hari_jual`.  

- **Menampilkan hasil transaksi terbaik**  
  ```python
  if max_keuntungan > 0:
      return f"Waktu terbaik untuk membeli: Hari ke-{hari_beli + 1} dengan harga {harga[hari_beli]}\n" \
             f"Waktu terbaik untuk menjual: Hari ke-{hari_jual + 1} dengan harga {harga[hari_jual]}\n" \
             f"Keuntungan maksimum: {max_keuntungan}"
  else:
      return "Tidak ada peluang keuntungan."
  ```  
  Jika **keuntungan > 0**, program akan memberikan rekomendasi kapan membeli dan menjual. Jika tidak ada keuntungan, maka program akan menampilkan pesan **"Tidak ada peluang keuntungan."**  

---

### **2. Input Harga Saham dari Pengguna**  
Bagian ini digunakan untuk menerima **input dari pengguna** mengenai jumlah hari dan harga saham setiap harinya.  

```python
n = int(input("Masukkan jumlah hari: "))
harga_saham = []
print("Masukkan harga saham untuk setiap hari:")
for i in range(n):
    harga = int(input(f"Hari ke-{i+1}: "))
    harga_saham.append(harga)
```
- `n`: Menyimpan jumlah hari untuk simulasi.  
- `harga_saham`: List untuk menyimpan harga saham yang dimasukkan pengguna.  
- **Looping** digunakan untuk meminta pengguna memasukkan harga saham tiap hari.  

---

### **3. Menjalankan Fungsi `trading_saham`**
Setelah mendapatkan data dari pengguna, program akan menjalankan fungsi untuk mencari transaksi terbaik.  

```python
hasil = trading_saham(harga_saham)
print(hasil)
```
- **Fungsi `trading_saham` dipanggil dengan list harga saham** yang telah dimasukkan.  
- **Hasilnya ditampilkan ke layar**.  

---

## **Contoh Input & Output**
### **Contoh 1 (Keuntungan Ada)**
#### **Input:**
```
Masukkan jumlah hari: 6
Masukkan harga saham untuk setiap hari:
Hari ke-1: 100
Hari ke-2: 80
Hari ke-3: 120
Hari ke-4: 70
Hari ke-5: 140
Hari ke-6: 110
```
#### **Proses:**
- Harga terendah (`70`) ditemukan di **Hari ke-4**.
- Harga tertinggi setelah itu (`140`) ditemukan di **Hari ke-5**.
- Keuntungan maksimum = **140 - 70 = 70**.  

#### **Output:**
```
Waktu terbaik untuk membeli: Hari ke-4 dengan harga 70
Waktu terbaik untuk menjual: Hari ke-5 dengan harga 140
Keuntungan maksimum: 70
```

---

### **Contoh 2 (Tidak Ada Keuntungan)**
#### **Input:**
```
Masukkan jumlah hari: 5
Masukkan harga saham untuk setiap hari:
Hari ke-1: 150
Hari ke-2: 140
Hari ke-3: 130
Hari ke-4: 120
Hari ke-5: 110
```
#### **Proses:**
- Harga terus turun, tidak ada peluang untuk untung.  

#### **Output:**
```
Tidak ada peluang keuntungan.
```

---

## **Kesimpulan**  
- Program ini **mencari peluang keuntungan tertinggi** dari harga saham harian yang diberikan.  
- Menggunakan **pendekatan linear O(n)** sehingga cukup efisien.  
- Berguna untuk **simulasi dasar strategi trading saham**.  

Jika ingin pengembangan lebih lanjut, bisa menambahkan:  
✅ **Visualisasi grafik harga saham**  
✅ **Fitur multiple transaksi** (beli-jual lebih dari sekali)  
✅ **Algoritma prediksi berbasis AI**  
