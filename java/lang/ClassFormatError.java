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
 * ��JVM��ͼ��ȡһ�����ļ�����ȷ�����ļ����ڸ�ʽ������ܽ���Ϊ���ļ�ʱ�׳���
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class ClassFormatError extends LinkageError {
    private static final long serialVersionUID = -8420114879011949195L;

    /**
     * ����һ���޲Σ���ϸ��Ϣ���� <code>ClassFormatError</code>��
     */
    public ClassFormatError() {
        super();
    }

    /**
     * ����һ����������ָ����ϸ��Ϣ���� <code>ClassFormatError</code>��
     *
     * @param   s   ��ϸ��Ϣ��
     */
    public ClassFormatError(String s) {
        super(s);
    }
}
