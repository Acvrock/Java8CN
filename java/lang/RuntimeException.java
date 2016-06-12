/*
 * Copyright (c) 1995, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * {@code RuntimeException}����Щ������JVM���������ڼ��׳����쳣�Ļ��ࡣ
 * 
 * <p>{@code RuntimeException}���������඼��<em>���ܼ��쳣</em>��
 * ��������ڷ�������������ʱ�׳����Ҵ��ݵ��˷����������߽�֮�⣬
 * ���ܼ��쳣�����ڷ�����������{@code throws}�Ӿ��н���������
 *
 *
 * @author  Frank Yellin
 * @jls 11.2 Compile-Time Checking of Exceptions
 * @since   JDK1.0
 */
public class RuntimeException extends Exception {
    static final long serialVersionUID = -7034897190745766939L;

    /** ����һ����{@code null}��Ϊ����ϸ��Ϣ������ʱ�쳣��
     * ������δ����ʼ������������{@link #initCause}���ý��г�ʼ����
     */
    public RuntimeException() {
        super();
    }

    /** ����һ��������ϸ��Ϣ������ʱ�쳣�� 
     * ������δ����ʼ������������{@link #initCause}���ý��г�ʼ����
     *
     * @param   message   ��ϸ��Ϣ����ϸ��Ϣ�������Թ�{@link #getMessage()}����ȡ�ء�
     */
    public RuntimeException(String message) {
        super(message);
    }

    /**
     * ����һ��������ϸ��Ϣ�����������ʱ�쳣��
     * <p>ע��{@code cause}����ϸ��Ϣ�����Զ��İ����ڸ�����ʱ�쳣����ϸ��Ϣ�С�
     *
     * @param  message ��ϸ��Ϣ������Ϣ�������Թ�{@link #getMessage()}�����Ժ�ȡ�أ���
     * @param  cause ���򣨸���Ϣ�������Թ�{@link #getCause()}�����Ժ�ȡ�أ���
     * 		        ������Ϊ<tt>null</tt>ֵ���������򲻴��ڻ�Ϊֹ��
     * @since  1.4
     */
    public RuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /** ����һ������ָ�������<tt>(cause==null ? null : cause.toString())</tt>����ϸ
     * ��Ϣ��һ���������Ϣ��<tt>cause</tt>����ϸ��Ϣ����
     * �ù�������������ʱ�쳣���ô���������Ϊ����throwable��ķ�װ����
     *
     * @param  cause ���� ������Ϣ�������Թ�{@link #getCause()}�����Ժ�ȡ�أ���
     * 		        ������Ϊ<tt>null</tt>ֵ���������򲻴��ڻ�Ϊֹ��
     * @since  1.4
     */
    public RuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     * ����һ������ָ����ϸ��Ϣ�������Ƿ�����쳣���Ƿ�д���ջ����������ʱ�쳣��
     *
     * @param  message ��ϸ��Ϣ��
     * @param cause ����  ������Ϊ<tt>null</tt>ֵ���������򲻴��ڻ�Ϊֹ��
     * @param enableSuppression �Ƿ�����쳣��
     * @param writableStackTrace �Ƿ�д���ջ��
     * 
     * @since 1.7
     */
    protected RuntimeException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
