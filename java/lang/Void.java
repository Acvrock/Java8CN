/*
 * Copyright (c) 1996, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * {@code Void}�����޷�ʵ������ռλ���࣬
 * �����б�ʾ Java�ؼ��� void��{@code Class}��������á�
 *
 * @author  unascribed
 * @since   JDK1.1
 */
public final
class Void {
	
    /**
     * {@code Class}�����ʾ��Ӧ�ؼ���{@code void}��α����
     */
    @SuppressWarnings("unchecked")
    public static final Class<Void> TYPE = (Class<Void>) Class.getPrimitiveClass("void");

    /*
     * Void���޷���ʵ����
     */
    private Void() {}
}
