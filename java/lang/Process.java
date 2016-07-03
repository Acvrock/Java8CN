/*
 * Copyright (c) 1995, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * 
 * {@link ProcessBuilder#start()}��
 * {@link Runtime#exec(String[],String[],File) Runtime.exec}����
 * ����һ�����ؽ��̲�����{@code Process}��һ��ʵ����
 * ����ʵ�������ڿ��ƽ��̲���ȡ����Ϣ��
 * {@code Process}���ṩ�ķ������ڻ�ȡ���̵������������̵��������
 * �ȴ�����ִ����ϣ������̵�ִ��״̬���Լ����٣�ɱ�������̡�
 *
 * <p>�ڹ̶��ı���ƽ̨�ϣ��������̵ķ������ض����̵�֧�ֿ��ܲ��ã����籾�ش��ڽ��̣��ػ����̣�
 * ΢��Windows�е�Win16/DOS���̣�������shell�ű���
 *
 * <p>Ĭ�ϵģ��������ӽ���û���Լ����ն˻����̨�������еı�׼I/O������stdin, stdout, stderr��
 * ���������ض����丸�����У��������п���ͨ��ʹ�÷���
 * {@link #getOutputStream()},
 * {@link #getInputStream()}, ��
 * {@link #getErrorStream()}����ȡ���������ʡ�
 * 
 * ������������Щ�������ӽ��̻�ȡ����������
 * ����һЩ����ƽֻ̨Ϊ����������ṩ���޵Ļ����С��
 * Ѹ�����ӽ���д���������������Ĵ�����ܻ������ӽ���������������������
 *
 * <p>ͬʱ��<a href="ProcessBuilder.html#redirect-input">
 * �ӽ���I/OҲ����ʹ��</a>{@link ProcessBuilder}��ķ������ض���
 *
 * <p>��������{@code Process}���������ʱ��
 * �ӽ��̲��ᱻɱ�����෴�ӽ��̻�����첽ִ�С�
 *
 * <p>����û�б�Ҫ�첽���С�
 *
 * 
 * <p>1.5�汾�У�{@link ProcessBuilder#start()}�Ǵ���{@code Process}����ѡ��ʽ��
 *
 * @since   JDK1.0
 */
public abstract class Process {
    /**
     * ��ȡ�ӽ��̵�����������ӽ������ӱ�׼���롣ͨ���ܵ��ӽ��̵ı�׼�����ȡ��׼������ݡ�
     *
     * <p>����ӽ��̵ı�׼���뱻ʹ��{@link ProcessBuilder#redirectInput(Redirect)
     * ProcessBuilder.redirectInput}�ض������
     * ��ô�÷���������<a href="ProcessBuilder.html#redirect-input">null�����</a>��
     *
     * <p>ʵ��ע������������ص���������л��沢���Ǻ����⡣
     *
     * @return ���ӵ��ӽ��̱�׼������������
     */
    public abstract OutputStream getOutputStream();

    /**
     * �������ӵ���׼�������������ͨ���ܵ��ӽ��̵ı�׼�����ȡ��׼�������ݡ�
     * 
     * <p>����ӽ��̵ı�׼�����ʹ��{@link ProcessBuilder#redirectOutput(Redirect)
     * ProcessBuilder.redirectOutput}�ض������
     * ��ô�÷���������<a href="ProcessBuilder.html#redirect-output">null������</a>��
     *
     *
     * <p>��������ӽ��̵ı�׼����ʹ��{@link ProcessBuilder#redirectErrorStream(boolean)
     * ProcessBuilder.redirectErrorStream}�ض���
     * ��ô�÷������ص�������������յ��ӽ��̺ϲ���ı�׼�������׼����
     *
     * <p>ʵ��ע����������ص����������л�����һ�������⡣ 
     *
     * @return ���ӵ��ӽ��������������������
     */
    public abstract InputStream getInputStream();

    /**
     * �����ӽ��������ӵ������������������ͨ���ܵ��ӽ��̵Ĵ��������ȡ���ݡ�
     * <p>����ӽ��̵ı�׼����ʹ��{@link ProcessBuilder#redirectError(Redirect)
     * ProcessBuilder.redirectError}����
     * {@link ProcessBuilder#redirectErrorStream(boolean)
     * ProcessBuilder.redirectErrorStream}�������ض���
     * ��ô�÷������᷵��һ��
     *
     * <p>ʵ��ע����������ص����������л�����һ�������⡣ 
     *
     * @return �ӽ����У����ӵ����������������
     */
    public abstract InputStream getErrorStream();

    /**
     * ʹ�õ�ǰ���̹߳���ȴ���������Ҫ��ֱ��{@code Process}���������ӽ�����ֹ��
     * ���{@code Process}������ֹ���÷����������ء�
     * ����ӽ���δ��ֹ�������߳̽��ᱻ������ֱ���ӽ����˳���
     *
     * @return {@code Process}�����ʾ���ӽ��̵��˳�ֵ��
     * 			���չ�����{@code 0}ֵ��ʾ������ֹ��
     * @throws InterruptedException �����ǰ�߳��ڵȴ���ʱ��
     * 		          �������̴߳�ϣ���ô�ȴ���ֹ�������׳�{@link InterruptedException}��
     */
    public abstract int waitFor() throws InterruptedException;

    /**
     * ʹ�õ�ǰ�̹߳���ȴ���������Ҫ��ֱ��{@code Process}���������ӽ�����ֹ��
     * ���߳�����ָ���ĵȴ�ʱ�䡣
     *
     * <p>����ӽ�������ֹ����ô�÷������̷���{@code true}ֵ��
     * ����ӽ���û����ֹ��timeoutֵС�ڻ�����趨ֵ��0ֵ����ô�÷�����������{@code false}ֵ��
     * <p>�÷�����Ĭ��ʵ��ͨ�����{@code exitValue}����ʵ�����Ƿ���ֹ��ǿ�ҽ����ھ�������ʱ��
     * ʹ��һ������Ч��ʵ�ֽ�����д��
     * 
     *
     * @param timeout ���ĵȴ�ʱ��
     * @param {@code timeout}������ʱ�䵥λ
     * @return ����ӽ������˳�����{@code true}������ȴ�ʱ�����ӽ����˳�ǰ��ʱ�򷵻�{@code false}��
     * @throws InterruptedException ����ڵȴ���ʱ��ǰ�̱߳���ϡ�
     * @throws NullPointerException �����λ��null
     * @since 1.8
     */
    public boolean waitFor(long timeout, TimeUnit unit)
        throws InterruptedException
    {
        long startTime = System.nanoTime();
        long rem = unit.toNanos(timeout);

        do {
            try {
                exitValue();
                return true;
            } catch(IllegalThreadStateException ex) {
                if (rem > 0)
                    Thread.sleep(
                        Math.min(TimeUnit.NANOSECONDS.toMillis(rem) + 1, 100));
            }
            rem = unit.toNanos(timeout) - (System.nanoTime() - startTime);
        } while (rem > 0);
        return false;
    }

    /**
     * �����ӽ��̵��˳�ֵ
     *
     * @return �ý��̵��˳�ֵ�����չ�����{@code 0}ֵ���������˳���
     * @throws IllegalThreadStateException ����ӽ��̻�û����ֹ
     */
    public abstract int exitValue();

    /**
     * ɱ���ӽ��̡������ӽ��̱�ǿ����ֹ���߾���ʵ��������
     */
    public abstract void destroy();

    /**
     * ɱ���ӽ��̡���{@code Process}���������ӽ��̱�ǿ����ֹ��
     *
     * <p>�÷�����Ĭ��ʵ�ֵ�����{@link #destroy}�������ʿ����޷�ǿ����ֹ��ǰ���̡�
     * �����ʵ�ִ�ʩ�У�ǿ�ҽ���ʹ����Ч��ʵ������д�÷�����
     * ���ø÷�����ǿ����ֹ���̣��� {@link ProcessBuilder#start}��
     * {@link Runtime#exec}��õĶ��󣩡�
     *
     * <p>ע�⣺�ӽ��̲���������ֹ��
     * ���磺{@code isAlive()}������{@code destroyForcibly()}
     * ���ú�Ķ�ʱ���ڷ���true��������Ҫ���÷���Ӧ��{@code waitFor()}�������ʹ�á�
     *
     * @return ��ǿ����ֹ�� {@code Process}���������ӽ��̡�
     * @since 1.8
     */
    public Process destroyForcibly() {
        destroy();
        return this;
    }

    /**
     * ���Ը�{@code Process}���������ӽ����Ƿ��
     *
     * @return {@code true} ������ӽ���δ����ֹ��
     * @since 1.8
     */
    public boolean isAlive() {
        try {
            exitValue();
            return false;
        } catch(IllegalThreadStateException e) {
            return true;
        }
    }
}
