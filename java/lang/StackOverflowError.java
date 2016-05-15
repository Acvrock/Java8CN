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
 * ���������ڵݹ���������ջ���ʱ�׳���
 *
 * @author unascribed
 * @since   JDK1.0
 */
public
class StackOverflowError extends VirtualMachineError {
    private static final long serialVersionUID = 8609175038441759607L;

    /**
     * ����һ���޲Σ���ϸ��Ϣ���� <code>StackOverflowError</code>��
     */
    public StackOverflowError() {
        super();
    }

    /**
     * ����һ����������ָ����ϸ��Ϣ���� <code>StackOverflowError</code>��
     *
     * @param   s   ��ϸ��Ϣ��
     */
    public StackOverflowError(String s) {
        super(s);
    }
}
