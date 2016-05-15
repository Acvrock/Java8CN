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
 * ��JVM��⵽�����ʱ���������д���ѭ������ʱ�׳���
 * 
 * @author     unascribed
 * @since      JDK1.0
 */
public class ClassCircularityError extends LinkageError {
    private static final long serialVersionUID = 1054362542914539689L;

    /**
     * ����һ���޲Σ���ϸ��Ϣ���� <code>ClassCircularityError</code>��
     * 
     */
    public ClassCircularityError() {
        super();
    }

    /**
     * ����һ����������ָ����ϸ��Ϣ���� <code>ClassCircularityError</code>��
     *
     * @param  s ��ϸ��Ϣ��
     */
    public ClassCircularityError(String s) {
        super(s);
    }
}
