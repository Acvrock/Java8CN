/*
 * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.io.Serializable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;

/**
 * ����������Java����ö�����͵Ĺ�ͬ���ࡣ
 *
 * ����ö�ٵĸ�����Ϣ�������ɱ������ϳɵ���ʽ����������������
 * ������<cite>The Java&trade; Language Specification</cite>
 * ��8.9�½��ҵ���
 *
 * <p>ע�⵱ʹ��ö��������Ϊһ�����ϵ����ͻ�����Ϊmap�м�������ʱ��
 * �ֳ���{@linkplain java.util.EnumSet set} �� {@linkplain
 * java.util.EnumMap map}��ʵ�ֶ���רҵ�͸�Ч�ġ�
 *
 * @param <E> ö����������
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see     Class#getEnumConstants()
 * @see     java.util.EnumSet
 * @see     java.util.EnumMap
 * @since   1.5
 */
public abstract class Enum<E extends Enum<E>>
        implements Comparable<E>, Serializable {

    /**
     * ö�ٳ��������ƣ���ö�������н���������
     * ���������ԱӦʹ��{@link #toString}���������Ƿ��ʸ���
     */
    private final String name;

    /**
     * 
     * ����ö�ٳ��������ƣ�����ö�������н���������
     *
     * <b>���������ԱӦʹ��{@link #toString}���������Ǹ÷�������ΪtoString����
     * �ܷ��ض��û����Ѻõ����� </b>�˷�����Ҫ��������������Σ�����ȷ�������ڻ�ȡ����ȷ�����ƣ�
     * �����Ʋ�����汾�ĸı���ı䡣
     *
     * @return ö�ٳ���������
     */
    public final String name() {
        return name;
    }

    /**
     * ö�ٳ���������������ö�������е�λ�ã��׸�����������ָ��Ϊ0����
     *
     * ���������Ҫ����Ҫʹ�ô���
     * �䱻������ڻ���ö�ٵĸ������ݽṹ��
     * ����{@link java.util.EnumSet} �� {@link java.util.EnumMap}��

     */
    private final int ordinal;

    /**
     * ����ö�ٳ���������������ö�������е�λ�ã��׸�����������ָ��Ϊ0����
     *
     * ���������Ҫ����Ҫʹ�ô˷�����
     * �䱻������ڻ���ö�ٵĸ������ݽṹ��
     * ����{@link java.util.EnumSet} �� {@link java.util.EnumMap}��
     *
     * @return ö�ٳ���������
     */
    public final int ordinal() {
        return ordinal;
    }

    /**
     * �������๹�췽��������Ա�޷����øù��췽����
     * ���ڱ������������ɣ�����Ӧö������������
     *
     * @param name - ö�ٳ��������ƣ������������������ó����ı�ʶ����
     * @param ordinal - ö�ٳ��������� ��ö�ٳ�����������λ�ã��׸�������������0����
     */
    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    /**
     * ����ö�ٳ��������ƣ������ѣ��������������С�
     * �÷������ܱ���д������ͨ������Ҫ��ô����
     * ������һ����Ϊ������Ա�Ѻá����ַ�����ʽ��Ӧ����д���������
     *
     * @return ö�����͵�����
     */
    public String toString() {
        return name;
    }

    /**
     * ָ���Ķ������ö�ٳ����򷵻��档
     *
     * @param other ��֮���е�ͬ�ԱȽϵĶ���
     * @return  ָ���Ķ������ö�ٳ����򷵻��档
     */
    public final boolean equals(Object other) {
        return this==other;
    }

    /**
     * Ϊö�ٳ������ع�ϣ��
     *
     * @return ö�ٳ����Ĺ�ϣ��
     */
    public final int hashCode() {
        return super.hashCode();
    }

    /**
     * �׳� CloneNotSupportedException��
     * ��ȷ��ö�ٶ����ǲ��ᱻ��¡��������Ǳ��֡�������״̬�Ǳ�Ҫ�ġ�
     *
     * @return (��������)
     */
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * �Ƚϸö�����ָ�������������
     * �������ϣ����ݸö���С�ڡ����ڻ��ߴ���ָ�����󣬷ֱ𷵻���Ӧ�ĸ�����0������������
     *
     * ö�ٳ���ֻ����ͬö�����͵ĳ������бȽϡ�
     * �÷���ʵ�ֵ���Ȼ˳����ǳ�������ʱ��˳��
     */
    public final int compareTo(E o) {
        Enum<?> other = (Enum<?>)o;
        Enum<E> self = this;
        if (self.getClass() != other.getClass() && // optimization
            self.getDeclaringClass() != other.getDeclaringClass())
            throw new ClassCastException();
        return self.ordinal - other.ordinal;
    }

    /**
     * ������ö�ٳ�����Ӧ��ö�����͵�Class����
     * ���ҽ���e1��e2����������e1.getDeclaringClass() == e2.getDeclaringClass()��
     * ö�ٳ���e1��e2��ö�����Ͳ���ͬ��
	 * ���÷������ص�ֵ��ͬ��{@link Object#getClass}��������ֵ��
	 * {@link Object#getClass}�������ڴ����ض��������������ö�ٳ�����
     *
     * @return ��ö�ٳ�����Ӧ��ö�����͵�Class����
     *     
     */
    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<?> clazz = getClass();
        Class<?> zuper = clazz.getSuperclass();
        return (zuper == Enum.class) ? (Class<E>)clazz : (Class<E>)zuper;
    }

    /**
     * ����ָ��ö�����͡�ָ�����Ƶ�ö�ٳ�����
     * ���Ʊ������ڴ�����������ö�ٳ������õı�ʶ����ȫƥ�䡣��������ʹ�ö���Ŀհ��ַ�����
     *
     * <p>ע�����ȷ�е�ö������{@code T}����ʽ������{@code public static T valueOf(String)}
     * ��������ʹ����ӳ�����Ƶ���һ��ö�ٳ����Ĺ�ϵ��������ʹ�ø÷�����
     * Ҫ��ȡ���е�ö�����ͳ���������ͨ��������ʽ��{@code public static T[] values()}
     * ������ʵ�֡�
     *
     * @param <T> Ҫ���з��س�����ö�����͵� Class����
     * @param enumType ö�����͵�{@code Class}���󣬾ݴ˷���һ������
     * @param name �����صĳ�����
     * @return ����ָ��ö�����͡�ָ�����Ƶ�ö�ٳ���
     * @throws IllegalArgumentException ��ָ����ö�����Ͳ�����ָ�����Ƶĳ�����
     * 		        ����ָ��������󲻴���ö�����͡�
     * @throws NullPointerException ��{@code enumType} �� {@code name}
     *         Ϊnull
     * @since 1.5
     */
    public static <T extends Enum<T>> T valueOf(Class<T> enumType,
                                                String name) {
        T result = enumType.enumConstantDirectory().get(name);
        if (result != null)
            return result;
        if (name == null)
            throw new NullPointerException("Name is null");
        throw new IllegalArgumentException(
            "No enum constant " + enumType.getCanonicalName() + "." + name);
    }

    /**
     * enum�಻��ӵ��finalize������
     */
    protected final void finalize() { }

    /**
     * ��ֹȱʡ�ķ����л�
     */
    private void readObject(ObjectInputStream in) throws IOException,
        ClassNotFoundException {
        throw new InvalidObjectException("can't deserialize enum");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize enum");
    }
}
