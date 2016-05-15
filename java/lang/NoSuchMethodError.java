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
 * ��Ӧ�ó�����ͼ�����ࣨ�����Ǿ�̬�໹�����ʵ������һ��δ����ķ���ʱ�׳���
 * <p>
 * ͨ�����ô����ɱ��������� �������
 * ֻ����������ʱ��ԭ����������ϴ��벻���ݡ�
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class NoSuchMethodError extends IncompatibleClassChangeError {
    private static final long serialVersionUID = -3765521442372831335L;

    /**
     * ����һ���޲Σ���ϸ��Ϣ���� <code>NoSuchMethodError</code>��
     */
    public NoSuchMethodError() {
        super();
    }

    /**
     * ����һ����������ָ����ϸ��Ϣ���� <code>NoSuchMethodError</code>��
     *
     * @param   s   ��ϸ��Ϣ.
     */
    public NoSuchMethodError(String s) {
        super(s);
    }
}
