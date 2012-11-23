package com.hisrv.leetcode;

public class DivideTwoIntegers {

	private class R {
		public long quo = 0;
		public long rem = 0;
	}

	private R div(long dividend, long divisor) {
		R r = new R();
		r.rem = dividend;
		while (r.rem >= divisor) {
			r.rem -= divisor;
			r.quo++;
		}
		return r;
	}

	private int len(long number) {
		return String.valueOf(number).length();
	}

	private long cat(long a, long b) {
		return Long.valueOf(String.valueOf(a) + String.valueOf(b));
	}

	private int at(long number, int i) {
		return Integer.valueOf(String.valueOf(number).substring(i, i + 1));
	}

	public int divide(int oridiv, int oridivisor) {
		// Start typing your Java solution below
		// DO NOT write main() function
		long dividend = oridiv;
		long divisor = oridivisor;
		boolean sign = true;
		if (dividend < 0) {
			sign = !sign;
			dividend = -dividend;
		}
		if (divisor < 0) {
			sign = !sign;
			divisor = -divisor;
		}
		long d = 0;
		long rst = 0;
		for (int i = 0; i < len(dividend); i++) {
			d = cat(d, at(dividend, i));
			R r = div(d, divisor);
			rst = cat(rst, r.quo);
			d = r.rem;
		}
		if (sign) {
			return (int)rst;
		} else {
			return (int)(-rst);
		}
	}
}
