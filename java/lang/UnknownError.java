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
 * ��δ֪�����ص��쳣����ʱ��JVM�׳���
 *
 * @author unascribed
 * @since   JDK1.0
 */
public
class UnknownError extends VirtualMachineError {
    private static final long serialVersionUID = 2524784860676771849L;

    /**
     * ����һ���޲Σ���ϸ��Ϣ���� <code>UnknownError</code>��
     */
    public UnknownError() {
        super();
    }

    /**
     * ����һ����������ָ����ϸ��Ϣ���� <code>UnknownError</code>��
     *
     * @param   s   ��ϸ��Ϣ.
     */
    public UnknownError(String s) {
        super(s);
    }
}
