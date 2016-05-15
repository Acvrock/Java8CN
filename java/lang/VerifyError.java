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
 * ����У��������⵽һ�����ļ���ʽ��ȷ��������һЩ�ڲ�һ���������ȫ����ʱ�׳���
 * 
 * @author  unascribed
 * @since   JDK1.0
 */
public
class VerifyError extends LinkageError {
    private static final long serialVersionUID = 7001962396098498785L;

    /**
     * ����һ���޲Σ���ϸ��Ϣ���� <code>VerifyError</code>��
     */
    public VerifyError() {
        super();
    }

    /**
     * ����һ����������ָ����ϸ��Ϣ���� <code>VerifyError</code>��
     *
     * @param   s   ��ϸ��Ϣ��
     */
    public VerifyError(String s) {
        super(s);
    }
}
