import unittest

# input: annual taxable income
# output: annual tax
# constraints: 
# - simple version of progressive tax, 
#   no need to handle NPWP ownership case
# - individual tax, not org tax
# - for citizen of Indonesia, not foreigner
def progressive_tax(income):
    max_percentage = 0.3
    limit_percent = { 50_000_000: 0.05, 200_000_000: 0.15, 250_000_000: 0.25 }
    total_tax = 0

    for limit, percent in limit_percent.items():
        remainder = income - limit
        if remainder <= 0:
            total_tax += income * percent
            income = remainder
            break
        else:
            total_tax += limit * percent
            income -= limit

    if income > 0:
        total_tax += income * max_percentage

    return total_tax

class TestProgressiveTax(unittest.TestCase):

    # https://www.talenta.co/blog/payroll/panduan-lengkap-penghitungan-pph-21-karyawan-dengan-contoh-soal/
    def test_case_1(self):
        input = 32_700_000
        expected = 1_635_000
        actual = progressive_tax(input)
        self.assertEqual(actual, expected)

    # https://www.online-pajak.com/tentang-pph-final/tarif-pasal-17
    def test_case_2(self):
        input = 60_000_000
        expected = 4_000_000
        actual = progressive_tax(input)
        self.assertEqual(actual, expected)

    # https://www.pajak.go.id/id/pph-pasal-2126
    def test_case_3(self):
        input = 75_000_000
        expected = 6_250_000
        actual = progressive_tax(input)
        self.assertEqual(actual, expected)

    # https://klikpajak.id/blog/perhitungan/cara-menghitung-penghasilan-kena-pajak-wp-orang-pribadi/
    def test_case_4(self):
        input = 226_000_000
        expected = 28_900_000
        actual = progressive_tax(input)
        self.assertEqual(actual, expected)

    # https://www.online-pajak.com/tentang-pph-final/tarif-pasal-17
    def test_case_5(self):
        input = 400_000_000
        expected = 70_000_000
        actual = progressive_tax(input)
        self.assertEqual(actual, expected)

    # https://www.linovhr.com/cara-menghitung-pph-21-dengan-gaji-di-atas-500-juta
    def test_case_6(self):
        input = 514_500_000
        expected = 99_350_000
        actual = progressive_tax(input)
        self.assertEqual(actual, expected)

if __name__ == '__main__':
    unittest.main()
