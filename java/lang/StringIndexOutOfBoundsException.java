/*
 * Copyright (c) 1994, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * {@code String}��ķ����׳�����������Ϊ�����߳����ַ����Ĵ�С��
 * ����ĳЩ����������charAt���������쳣�����������ַ�����С��ͬʱ�׳���
 * 
 * @author  unascribed
 * @see     java.lang.String#charAt(int)
 * @since   JDK1.0
 */
public
class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = -6762910422159637258L;

    /**
     * ����һ���޲ε�{@code StringIndexOutOfBoundsException}��
     *
     * @since   JDK1.0.
     */
    public StringIndexOutOfBoundsException() {
        super();
    }

    /**
     * ����һ������ָ����ϸ��Ϣ��{@code StringIndexOutOfBoundsException}��
     *
     * @param   s   ��ϸ��Ϣ
     */
    public StringIndexOutOfBoundsException(String s) {
        super(s);
    }

    /**
     * ����һ�����зǷ�����������{@code StringIndexOutOfBoundsException}�ࡣ
     *
     * @param   index   �Ƿ�����
     */
    public StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
    }
}
