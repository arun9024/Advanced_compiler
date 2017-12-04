#!/usr/bin/env python
import os, os.path
compiler = 'java -ea -cp classes:/usr/local/lib/antlr-4.5.1-complete.jar Main'
interpreter = 'java -ea -jar IRInterpreter.jar'

def get_tests():
    ls = os.listdir('test')
    ls = [ s[0:-len('.tack')] for s in ls if s.endswith('.tack') ]
    ls.sort()
    return ls

def diff(f1, f2):
    rv = os.system("diff -w -I '#' -q %s %s" % (f1, f2))
    if 0 != rv:
        os.system("diff -w -I '#' %s %s" % (f1, f2))
        return False
    return True

total_tests = 0
total_failed = 0

for test in get_tests():
    print '---- test %s ----' % test
    total_tests = total_tests + 1
    comp = '%s test/%s.tack' % (compiler, test)
    os.system('%s > tmp/%s.ir' % (comp, test))
    if not os.path.exists('tmp/%s.ir' % test):
        print 'test %s FAILED in compiler:\n  %s' % (test, comp)
        total_failed = total_failed + 1
    else:
        intp = '%s tmp/%s.ir > tmp/%s.out' % (interpreter, test, test)
        os.system('%s' % intp)
        if not diff('test/%s.out' % test, 'tmp/%s.out' % test):
            print 'test %s FAILED in interpreter:\n  %s' % (test, intp)
            total_failed = total_failed + 1        

if 0 != total_failed:
    print '\nFAILED %d out of %d tests' % (total_failed, total_tests)
else:
    print '\nSUCCESS'
