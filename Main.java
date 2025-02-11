def trading_saham(harga):
    if len(harga) < 2:
        return "Data harga saham tidak cukup!"

    min_harga = harga[0]  # Harga beli awal
    max_keuntungan = 0     # Keuntungan maksimum
    hari_beli = 0
    hari_jual = 0

    for i in range(1, len(harga)):
        # Jika menemukan harga beli yang lebih murah
        if harga[i] < min_harga:
            min_harga = harga[i]
            hari_beli = i  # Simpan hari beli

        # Hitung keuntungan jika jual di hari ini
        keuntungan = harga[i] - min_harga
        if keuntungan > max_keuntungan:
            max_keuntungan = keuntungan
            hari_jual = i  # Simpan hari jual

    # Tampilkan hasil
    if max_keuntungan > 0:
        return f"Waktu terbaik untuk membeli: Hari ke-{hari_beli + 1} dengan harga {harga[hari_beli]}\n" \
               f"Waktu terbaik untuk menjual: Hari ke-{hari_jual + 1} dengan harga {harga[hari_jual]}\n" \
               f"Keuntungan maksimum: {max_keuntungan}"
    else:
        return "Tidak ada peluang keuntungan."

# Input jumlah hari dan harga saham
n = int(input("Masukkan jumlah hari: "))
harga_saham = []

print("Masukkan harga saham untuk setiap hari:")
for i in range(n):
    harga = int(input(f"Hari ke-{i+1}: "))
    harga_saham.append(harga)

# Jalankan fungsi trading_saham
hasil = trading_saham(harga_saham)
print(hasil)
