#!/usr/bin/env python
import argparse, logging


def main(args, loglevel):
    logging.basicConfig(format="%(levelname)s: %(message)s", level=loglevel)

    print "Hello there."
    logging.debug("Your Arguments: %s" % args.argument)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description="Does a thing to some stuff.")
    parser.add_argument('argument', nargs='*')
    parser.add_argument("-v",
                        "--verbose",
                        help="increase output verbosity",
                        action="store_true")
    args = parser.parse_args()

    # Setup logging
    if args.verbose:
        loglevel = logging.DEBUG
    else:
        loglevel = logging.INFO

    main(args, loglevel)
