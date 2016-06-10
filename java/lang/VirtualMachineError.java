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
 * �׳��ô�����ָʾJVM���𻵻��߼��������������Դ�Ѻľ���
 *
 * @author  Frank Yellin
 * @since   JDK1.0
 */
abstract public class VirtualMachineError extends Error {
    private static final long serialVersionUID = 4161983926571568670L;

    /**
     * ����һ��û����ϸ˵����Ϣ��<code>VirtualMachineError</code>��
     */
    public VirtualMachineError() {
        super();
    }

    /**
     * ����һ��������ϸ˵����Ϣ��<code>VirtualMachineError</code>��
     *
     * @param   message   ��ϸ��Ϣ��
     */
    public VirtualMachineError(String message) {
        super(message);
    }

    /**
     * ����һ��������ϸ˵����Ϣ�������<code>VirtualMachineError</code>��
     * <p>ע����{@code cause}��������ϸ��Ϣ�����Զ������ڸô������ϸ��Ϣ�С�
     *
     * @param  message ��ϸ��Ϣ�����������{@link #getMessage()}����ȡ��ʹ�ã�
     * @param  cause ���򣨱��������{@link #getCause()}����ȡ��ʹ�ã���
     * 		         ������{@code null}ֵ����ʾ�����򲻴��ڻ�δ֪ ����
     * @since  1.8
     */
    public VirtualMachineError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * ����һ��������ϸ�����{@code (cause==null ? null : cause.toString())}
     * ��ϸ��Ϣ��{@code VirtualMachineError}��
     * ��ͨ���������{@code cause}����ϸ��Ϣ����
     *
     * @param  cause ���� �����������{@link #getCause()}����ȡ��ʹ�ã���
     * 		         ������{@code null}ֵ����ʾ�����򲻴��ڻ�δ֪ ����
     * @since  1.8
     */
    public VirtualMachineError(Throwable cause) {
        super(cause);
    }
}
