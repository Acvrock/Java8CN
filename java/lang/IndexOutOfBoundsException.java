/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
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
 * �׳��Ա���ĳЩ������󣨱������飬�ַ���������������Խ�硣
 * <p>
 * Ӧ�ó������Ϊ����ഴ�����࣬�Ա������Ƶ��쳣��
 *
 * @author  Frank Yellin
 * @since   JDK1.0
 */
public
class IndexOutOfBoundsException extends RuntimeException {
    private static final long serialVersionUID = 234122996006267687L;

    /**
     * ����һ���޲ε�<code>IndexOutOfBoundsException</code>��
     */
    public IndexOutOfBoundsException() {
        super();
    }

    /**
     * ����һ������ָ����ϸ��Ϣ��<code>IndexOutOfBoundsException</code>��
     *
     * @param   s   ��ϸ��Ϣ��
     */
    public IndexOutOfBoundsException(String s) {
        super(s);
    }
}
