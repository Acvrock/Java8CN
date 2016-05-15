/*
 * Copyright (c) 1994, 2008, Oracle and/or its affiliates. All rights reserved.
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
 * ��������ͼ������СΪ�����������׳���
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class NegativeArraySizeException extends RuntimeException {
    private static final long serialVersionUID = -8960118058596991861L;

    /**
     * ����һ���޲Σ���ϸ��Ϣ���� <code>NegativeArraySizeException</code>��
     * 
     */
    public NegativeArraySizeException() {
        super();
    }

    /**
     * ����һ����������ָ����ϸ��Ϣ���� <code>NegativeArraySizeException</code>��
     * 
     *
     * @param   s   ��ϸ��Ϣ.
     */
    public NegativeArraySizeException(String s) {
        super(s);
    }
}
