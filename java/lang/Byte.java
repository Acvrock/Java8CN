/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.lang;

/**
 * {@code Byte}��һ����������{@code byte}��ֵ��װ���˶����С�
 * ����{@code Byte}��һ������ֻ����һ������Ϊ{@code byte}����
 *
 * <p>���⣬���໹�ṩ��{@code byte}��{@code String}֮�以ת�ķ���
 * �Լ��ڴ���{@code byte}ʱһЩ���õĳ����ͷ�����
 *
 * @author  Nakul Saraiya
 * @author  Joseph D. Darcy
 * @see     java.lang.Number
 * @since   JDK1.1
 */
public final class Byte extends Number implements Comparable<Byte> {

    /**
     *  �ó���������{@code byte}�������͵���Сֵ��-2<sup>7</sup>��
     */
    public static final byte   MIN_VALUE = -128;

    /**
	 *�ó���������{@code byte}�������͵���Сֵ��2<sup>7</sup>-1��
     */
    public static final byte   MAX_VALUE = 127;

    /**
     * {@code Class} ʵ����ʾ{@code byte}�Ļ������͡�
     */
    @SuppressWarnings("unchecked")
    public static final Class<Byte>     TYPE = (Class<Byte>) Class.getPrimitiveClass("byte");

    /**
     * �����ŵ�{@code String}���󣬴���ָ����
     * {@code byte}������Ĭ��Ϊ10��
     *
     * @param b ��ת����{@code byte}
     * @return ָ��{@code byte}���ַ�����ʾ
     * @see java.lang.Integer#toString(int)
     */
    public static String toString(byte b) {
        return Integer.toString((int)b, 10);
    }

    private static class ByteCache {
        private ByteCache(){}

        static final Byte cache[] = new Byte[-(-128) + 127 + 1];

        static {
            for(int i = 0; i < cache.length; i++)
                cache[i] = new Byte((byte)(i - 128));
        }
    }

    /**
     * ����һ��{@code Byte}ʵ������ʾָ����
     * {@code byte}ֵ��
     * �������Ҫ������{@code Byte}ʵ����һ��ʹ�ø÷���
     * �����ǹ�����{@link #Byte(byte)}��
     * ��Ϊ�ڴ˷����У�����byteֵ��������������߳����ʱ�估�ռ�Ч�ʡ�
     *
     * @param  b һ��byteֵ��
     * @return ����{@code b}��{@code Byte}ʵ����
     * @since  1.5
     */
    public static Byte valueOf(byte b) {
        final int offset = 128;
        return ByteCache.cache[(int)b + offset];
    }

    /**
     * ���ݲ�����ָ���Ļ��������ƣ�����String���Ͳ���һ����Ϊ�з��ŵ�{@code byte}��
     * ���˵�һ���ַ�������һ����ʾ��ֵ��ASCII�븺��{@code '-'}({@code '\u005Cu002D'})
     * ���߱�ʾ��ֵ��ASCII������{@code '+'} ({@code '\u005Cu002B'})��
     * �ַ��������е��ַ���������ָ��������ȡ����{@link java.lang.Character#digit(char,int)}�Ƿ񷵻���ֵ��������, 
	 * �÷������صõ�{@code byte}ֵ��
     *
     * <p>�緢��������������׳�{@code NumberFormatException}��
     * <ul>
     * <li> �׸�����Ϊ {@code null}��Ϊ����Ϊ����ַ���
     *
     * <li> ����С�� {@link java.lang.Character#MIN_RADIX} 
     * ����� {@link java.lang.Character#MAX_RADIX}��
     *
     * <li> �ַ�������һ�ַ�����ָ�����������֣�
     * ��һ���ַ��Ǹ��� {@code '-'} ({@code '\u005Cu002D'})��
     * ��������{@code '+'} ({@code '\u005Cu002B'})
     * ��������⣨���������ַ������ȳ��� 1����
     * 
     * <li> �ַ��������ֵ��������{@code byte}��ֵ�� 

     * </ul>
     *
     * @param s         ����{@code byte}��ʾ�Ĵ�������{@code String}
     * 
     * @param radix     ����{@code s}ʱʹ�õĻ���
     * @return          ��ָ��������ʾ���ַ���������ʾ��{@code byte}ֵ��
     *                  
     * @throws          NumberFormatException ����ַ����������ɽ�����{@code byte}��
     */
    public static byte parseByte(String s, int radix)
        throws NumberFormatException {
        int i = Integer.parseInt(s, radix);
        if (i < MIN_VALUE || i > MAX_VALUE)
            throw new NumberFormatException(
                "Value out of range. Value:\"" + s + "\" Radix:" + radix);
        return (byte)i;
    }

    /**
     * ���ַ�������ת��Ϊ�з��ŵ� ʮ����{@code byte}��
     * �����׸��ַ��Ǳ�ʾ��ֵ��ASCII����{@code '-'}({@code '\u005Cu002D'})��
     * �����Ǳ�ʾ��ֵ��ASCII����{@code '+'}({@code '\u005Cu002B'})֮�⣬
     * �ַ����е������ַ���������ʮ�������֡�
     * �÷������صõ���{@code byte}ֵ�������{@link parseByte(java.lang.String, int)}����
     * ʱ�����ڶ�������������Ϊ10�õ��Ľ����ͬ��
     *
     * @param s         ����{@code byte}��ʾ�Ĵ�������{@code String}
     * @return          ��ʮ���Ʊ�ʾ���ַ���������ʾ��{@code byte}ֵ��
     * @throws          NumberFormatException ���ַ����������ɽ�����{@code byte}��
     */
    public static byte parseByte(String s) throws NumberFormatException {
        return parseByte(s, 10);
    }

    /**
     * ����һ��{@code Byte}���󣬸ö��󱣴��ָ��{@code String}��������ȡ��ֵ��
     * ��ֵ�ɵڶ������������Ļ�����ָ���ַ������н���ʱ��ȡ��
     * ��һ������ʹ�õڶ���������ָ���Ļ��������ͱ�ʾһ���з��ŵ� {@code byte}��
	 *�����һ�����ַ�����ʾ��{@code byte}ֵ��{@code Byte}����
     *
     * <p> ����֮���÷������ص�{@code Byte}����������淽���ķ���ֵ��
     *
     * <blockquote>
     * {@code new Byte(Byte.parseByte(s, radix))}
     * </blockquote>
     *
     * @param s         ���������ַ���
     * @param radix     ����{@code s}ʱʹ�õĻ���
     * @return          �����ַ���������{@code Byte}����
     * @throws          ��{@code String}�������ɽ�����{@code byte}��
     */
    public static Byte valueOf(String s, int radix)
        throws NumberFormatException {
        return valueOf(parseByte(s, radix));
    }

    /**
     * ����ָ����{@code String}��ʾ��ֵ��{@code Byte}����
     * ����������Ϊһ���з��ŵ�ʮ����{@code byte}���뽫�������ݸ�
     * {@link #parseByte(java.lang.String)}�����õ��Ľ��һ����
     * �����һ�����ַ�����ʾ��{@code byte}ֵ��{@code Byte}����
     *
     * <p> ����֮���÷������ص�{@code Byte}����������淽���ķ���ֵ��
     *
     * <blockquote>
     * {@code new Byte(Byte.parseByte(s))}
     * </blockquote>
     *
     * @param s         ���������ַ���
     * @return          �����ַ���������{@code Byte}����
     * @throws          ��{@code String}�������ɽ�����{@code byte}��
     */
    public static Byte valueOf(String s) throws NumberFormatException {
        return valueOf(s, 10);
    }

    /**
     * ��{@code String}����Ϊ {@code Byte}��
     * ��������﷨������ʮ���ơ�ʮ�����ƣ��˽������֣�
     *
     * <blockquote>
     * <dl>
     * <dt><i>�ɽ�����ַ�����</i>
     * <dd><i>Sign<sub>opt</sub> DecimalNumeral</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code 0x} <i>HexDigits</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code 0X} <i>HexDigits</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code #} <i>HexDigits</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code 0} <i>OctalDigits</i>
     *
     * <dt><i>Sign:</i>
     * <dd>{@code -}
     * <dd>{@code +}
     * </dl>
     * </blockquote>
     *
     * <cite>The Java&trade; Language Specification</cite>
     * ��3.10.1�½ڸ�����<i>DecimalNumeral</i>, <i>HexDigits</i>�� <i>OctalDigits</i>
     * �Ķ��塣����������֮����»��ߡ�
     *
     * �Կ�ѡ���ź�/�����˵��������{@code 0x}������{@code 0X}������{@code #}�� ��ǰ���㣩������ַ����н��н�������ʹ�ô�ָ��������10��16 �� 8���� {@code Byte.parseByte}�������һ����
     * ���ַ����б����ʾһ����ֵ�������׳� {@link NumberFormatException}��
     * ���ָ�� {@code String}�ĵ�һ���ַ��Ǹ��ţ����������󷴡�
     * {@code String}�в�������ֿո��ַ���
     *
     * @param   nm �������{@code String}��
     * @return  �� {@code nm}��ʾ�� {@code byte}ֵ�� {@code Byte}����
     * @throws  NumberFormatException  ��{@code String}�������ɽ�����{@code byte}��
     * @see java.lang.Byte#parseByte(java.lang.String, int)
     */
    public static Byte decode(String nm) throws NumberFormatException {
        int i = Integer.decode(nm);
        if (i < MIN_VALUE || i > MAX_VALUE)
            throw new NumberFormatException(
                    "Value " + i + " out of range from input " + nm);
        return valueOf((byte)i);
    }

    /**
     * {@code Byte}��ֵ��
     *
     * @serial
     */
    private final byte value;

    /**
     * ����һ�������ɵ�{@code Byte}����
     * ��ʾָ����{@code byte}ֵ��
     *
     * @param value     ����{@code Byte}��ֵ��
     *                  
     */
    public Byte(byte value) {
        this.value = value;
    }

    /**
     * ����һ�������ɵ�{@code Byte}���󣬸ö��������{@code String}����
     * ת��������{@code byte}ֵ�����ַ�����ת��Ϊһ��{@code byte}ֵ��
     * ��ֵ�ɻ���Ϊ10��{@code parseByte}�������õõ���
     *
     * @param s         ��ת��Ϊ{@code Byte}��{@code String}��
     * @throws          ��{@code String}�������ɿ�ת����{@code byte}����
     * 					�׳�NumberFormatException��
     * @see        		java.lang.Byte#parseByte(java.lang.String, int)
     */
    public Byte(String s) throws NumberFormatException {
        this.value = parseByte(s, 10);
    }

    /**
     * ��{@code byte}��ʽ���ش�{@code Byte}��ֵ��
     */
    public byte byteValue() {
        return value;
    }

    /**
     * �����������͵�����ת������{@code short}��ʽ���ش�{@code Byte}��ֵ��
     * @jls 5.1.2 ������������ת��
     */
    public short shortValue() {
        return (short)value;
    }

    /**
     * �����������͵�����ת������{@code int}��ʽ���ش�{@code Byte}��ֵ��
     * @jls 5.1.2 ������������ת��
     */
    public int intValue() {
        return (int)value;
    }

    /**
     * �����������͵�����ת������{@code long}��ʽ���ش�{@code Byte}��ֵ��
     * @jls 5.1.2 ������������ת��
     */
    public long longValue() {
        return (long)value;
    }

    /**
     * �����������͵�����ת������{@code float}��ʽ���ش�{@code Byte}��ֵ��
     * @jls 5.1.2 ������������ת��
     */
    public float floatValue() {
        return (float)value;
    }

    /**
     * �����������͵�����ת������{@code double}��ʽ���ش�{@code Byte}��ֵ��
     * @jls 5.1.2 ������������ת��
     */
    public double doubleValue() {
        return (double)value;
    }

    /**
     * ����һ��{@code String}���󣬴���{@code Byte}��ֵ��
     * ��ֵ��ת��Ϊ�з��ŵ�ʮ��������ʾ������Ϊ�ַ������ء�
     * ����{@code byte}ֵ��Ϊ����{@link java.lang.Byte#toString(byte)}
     * �Ĳ��������õ��Ľ��һ����
     *
     * @return  ��ʾ�ö����ʮ������ʽ���ַ���
     */
    public String toString() {
        return Integer.toString((int)value);
    }

    /**
     * Ϊ��{@code Byte}����һ����ϣ�룻�����{@code intValue()}�Ľ��equal to the result
     * ��ͬ.
     *
     * @return Ϊ��{@code Byte}��һ����ϣ��
     */
    @Override
    public int hashCode() {
        return Byte.hashCode(value);
    }

    /**
     * Ϊ{@code byte}ֵ���ع�ϣ�룻
     * ��{@code Byte.hashCode()}���ݡ�
     *
     * @param value ����ϣ��ֵ
     * @return Ϊ{@code byte}ֵ���ع�ϣ�롣
     * @since 1.8
     */
    public static int hashCode(byte value) {
        return (int)value;
    }

    /**
     * �Ƚϸö�����ָ���Ķ���
     * ���ҽ���������Ϊ{@code null}
     * ͬʱ������������ö�������ͬ��{@code byte}ֵ��{@code Byte}����
     * ʱ����{@code true}��
     *
     * @param obj       ��֮�ȽϵĶ���
     * @return          ����������ͬ�򷵻�{@code true}��
     *                  ����{@code false}��
     */
    public boolean equals(Object obj) {
        if (obj instanceof Byte) {
            return value == ((Byte)obj).byteValue();
        }
        return false;
    }

    /**
     * �Ƚ�����{@code Byte}�����������ʽ��
     *
     * @param   ��{@code Byte}�Ƚϵ���һByte����
     * @return  ��{@code Byte}�����{@code Byte}��ȣ��򷵻�{@code 0}��
     * 			��{@code Byte}С�ڲ���{@code Byte}���򷵻���С��{@code 0}��
     * 			��{@code Byte}���ڲ���{@code Byte}���򷵻�������{@code 0}
     * 			���з��űȽϣ���
     * @since   1.2
     */
    public int compareTo(Byte anotherByte) {
        return compare(this.value, anotherByte.value);
    }

    /**
     * �Ƚ�����{@code byte}ֵ��������ʽ��
     * ����ֵ�뷽��
     * <pre>
     *    Byte.valueOf(x).compareTo(Byte.valueOf(y))
     * </pre>
     * �ķ���ֵ��ȡ�
     * @param  x �Ƚϵĵ�һ��{@code byte}
     * @param  y �Ƚϵĵڶ���{@code byte}
     * @return ��{@code x == y}����{@code 0}��
     *         ��{@code x < y}����ֵС��{@code 0}��
     *         ��{@code x > y}����ֵ����{@code 0}��
     * @since 1.7
     */
    public static int compare(byte x, byte y) {
        return x - y;
    }

    /**
     * ͨ���޷���ת����������ת��Ϊһ��{@code int}��
     * ���޷���ת��Ϊһ��{@code int}ʱ��{@code int}�ĸ�24λΪ0��ʣ�µĵ�8λ
     * ͬ{@code byte}�����Ķ�����λ��ͬ��
     *
     * ��ˣ�0��������{@code byte}ֵ��ӳ�������ȵ�{@code int}���֣�
     * ��������{@code byte}ֵ��ӳ���һ��������ֵ����2<sup>8</sup>���õ���{@code int}����
     *
     * @param  x ��ת��Ϊ�޷���{@code int}��ֵ
     * @return ������ͨ���޷���ת����Ϊ{@code int}���ֵ��
     * @since 1.8
     */
    public static int toUnsignedInt(byte x) {
        return ((int) x) & 0xff;
    }

    /**
     *
     * ͨ���޷���ת����������ת��Ϊһ��{@code long}��
     * ���޷���ת��Ϊһ��{@code long}ʱ��{@code long}�ĸ�56λΪ0��ʣ�µĵ�8λ
     * ͬ{@code byte}�����Ķ�����λ��ͬ��
     * 
     * ��ˣ�0��������{@code byte}ֵ��ӳ�������ȵ�{@code long}���֣�
     * ��������{@code byte}ֵ��ӳ���һ��������ֵ����2<sup>8</sup>���õ���{@code long}����
     *
     * @param  x ��ת��Ϊ�޷���{@code long}��ֵ
     * @return ������ͨ���޷���ת����Ϊ{@code long}���ֵ��
     *         
     * @since 1.8
     */
    public static long toUnsignedLong(byte x) {
        return ((long) x) & 0xffL;
    }


    /**
     * �Զ����Ʋ�����ʽ��ʾ{@code byte}ֵ��λ����
     *
     * @since 1.5
     */
    public static final int SIZE = 8;

    /**
     * �Զ����Ʋ�����ʽ��ʾ{@code byte}ֵ���ֽ�����
     *
     * @since 1.8
     */
    public static final int BYTES = SIZE / Byte.SIZE;

    /** use serialVersionUID from JDK 1.1. for interoperability */
    private static final long serialVersionUID = -7183698231559129828L;
}
